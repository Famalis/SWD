/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.AuxGUI.AuxFrame;
import Engine.MouseClickListener;
import Engine.Point;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sergio
 */
public class Easel extends JFrame {

	public int xsize = 600, ysize = 600;
	public Board board;
	public AuxFrame auxFrame;

	public Easel() {
		super();
	}
	

	/**
	 * Metoda, którą należy wywołać, aby w pełni przygotować okno.
	 * @return 
	 */
	public boolean initialize() {
		board = new Board();
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
		if (board.getPoints().size() == 2) {
			board.getPoints().clear();
		}
		board.getPoints().add(new Point(x, y));
		this.repaint();
		return true;
	}
}
