/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.AuxGUI.AuxFrame;
import Engine.MouseClickListener;
import Engine.Models.Perceptron;
import Engine.Models.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sergio
 */
public class Easel extends JFrame {

	public int xsize = 600, ysize = 600;
	public Board2 board;
	public AuxFrame auxFrame;
	public static double desiredSum = 5;

	public Easel() {
		super();
	}

	/**
	 * Metoda, którą należy wywołać, aby w pełni przygotować okno.
	 *
	 * @return
	 */
	public boolean initialize() {
		board = new Board2();
		board.addMouseListener(new MouseClickListener(this));
		add(board);
		setTitle("Pointer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(xsize, ysize);
		setVisible(true);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				auxFrame = new AuxFrame();
				auxFrame.initialize();
				auxFrame.getDrawPerceptronButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						board.setDrawVector(true);
						auxFrame.getSettingsPanel().getDrawPeceptron().setEnabled(false);
					}

				});

				auxFrame.getStartButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<Point> learningSet = new ArrayList<>();
						for (int i = -10; i <= 10; i++) {
							learningSet.add(new Point(i, 5 - i, 1, true));
							//System.out.println(i+" "+(5-i));
						}

						for (int i = 0; i < 1000; i++) {
							Double x = Math.random() * (Point.screenWidth);
							Double y = Math.random() * (Point.screenHeight);
							Point p = new Point((int) Math.round(x), (int) Math.round(y));
							if (p.getAxisX() + p.getAxisY() == desiredSum) {
								p.status = 1;
							} else {
								p.status = 0;
							}
							learningSet.add(p);
							System.out.println(p.x+" "+p.y+" "+(p.getAxisX()+p.getAxisY()));
						}
						board.getPerceptron().learn(learningSet);
						board.repaint();
					}

				});
			}
		});
		Point.screenHeight = ysize;
		Point.screenWidth = xsize;

		return true;
	}

	/**
	 * Rysuje jeden punkt o podanych współrzędnych x,y. (współrzędne względem
	 * górnej, lewej krawędzi okna)
	 *
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean drawPoint(int x, int y) {
		board.getPoints().add(new Point(x, y));
		this.repaint();
		return true;
	}

	public void drawVectorPoint(int x, int y) {
		if (board.getPerceptron().getEndPoint() != null) {
			board.setPerceptron(new Perceptron());
			board.getPerceptron().setStartPoint(new Point(x, y));
		} else {
			board.getPerceptron().setEndPoint(new Point(x, y));
			board.setDrawVector(false);
			auxFrame.getSettingsPanel().getDrawPeceptron().setEnabled(true);
		}
		this.repaint();
	}

	public void startDrawingVector() {
		board.setDrawVector(true);
	}

	public void stopDrawingVector() {
		board.setDrawVector(false);
	}

	public boolean drawingVector() {
		return board.isDrawVector();
	}
}
