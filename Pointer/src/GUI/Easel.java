/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Engine.Models.Point;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author sergio
 */
public class Easel extends JFrame{
	
	private Board board;
	private boolean drawingVector;
	
	public Easel() {
		drawingVector = false;
	}
	
	public void initalization() {
		Point.setScreenHeight(580);
		Point.setScreenWidth(600);
		board = new Board();
		add(board);
		setTitle("Pointer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Point.getScreenWidth(), Point.getScreenHeight());		
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);		
	}

	public boolean isDrawingVector() {
		return drawingVector;
	}

	public void setDrawingVector(boolean drawingVector) {
		this.drawingVector = drawingVector;
	}

	public Board getBoard() {
		return board;
	}
	
}
