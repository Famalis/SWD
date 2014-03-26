/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Engine.Models.Point;
import javax.swing.JFrame;

/**
 *
 * @author sergio
 */
public class Easel extends JFrame{
	
	private Board board;
	private boolean drawingVector, select0, select1;
	
	public Easel() {
		drawingVector = false;
		select0 = false;
		select1 = false;
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

	public boolean isSelect0() {
		return select0;
	}

	public void setSelect0(boolean select0) {
		this.select0 = select0;
	}

	public boolean isSelect1() {
		return select1;
	}

	public void setSelect1(boolean select1) {
		this.select1 = select1;
	}
	
}
