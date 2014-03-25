/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.AuxGUI.AuxFrame;
import Engine.MouseClickListener;
import Engine.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	public Easel() {
		super();
	}
	

	/**
	 * Metoda, którą należy wywołać, aby w pełni przygotować okno.
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
			}
		});		
		Point.screenHeight = ysize;
		Point.screenWidth = xsize;
		return true;
	}

	/**
	 * Rysuje jeden punkt o podanych współrzędnych x,y. (współrzędne względem
	 * górnej, lewej krawędzi okna)
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
		if(board.getPerceptronPoints()[1]!=null) {
			board.setPerceptronPoints(new Point[2]);
			board.getPerceptronPoints()[0] = new Point(x,y);
		} else {
			board.getPerceptronPoints()[1] = new Point(x,y);
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
