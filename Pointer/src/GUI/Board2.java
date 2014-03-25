/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Engine.Perceptron;
import Engine.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author sergio
 */
public class Board2 extends JPanel {

	private int width, height;
	private ArrayList<Point> selectedPoints;
	private Perceptron perceptron;
	private boolean drawVector = false;

	public Board2() {
		super();
		this.selectedPoints = new ArrayList<>();
		this.perceptron = new Perceptron();
	}

	@Override
	public void paint(Graphics g) {
		this.setDoubleBuffered(true);
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh
				= new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g2.setRenderingHints(rh);
		Dimension size = getSize();
		Insets insets = getInsets();
		width = size.width - insets.left - insets.right;
		height = size.height - insets.top - insets.bottom;
		paintPoints(g2);
		paintPerceptron(g2);
		paintAxes(g2);
	}

	/**
	 * Rysuje osie
	 *
	 * @param g2
	 */
	private void paintAxes(Graphics2D g2) {
		g2.setColor(Color.black);
		float[] dash = {2f, 0f, 2f};
		BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 1.0f, dash, 2f);
		g2.setStroke(bs1);
		g2.drawLine(width / 2, 0, width / 2, height);
		g2.drawLine(0, height / 2, width, height / 2);
	}

	public void paintPoints(Graphics2D g2) {
		g2.setColor(Color.red);
		for (Point p : selectedPoints) {
			g2.drawLine(p.x, p.y, p.x, p.y);
		}
	}

	public void paintPerceptron(Graphics2D g2) {
		if (perceptron.getStartPoint() != null ||
				perceptron.getStartPoint() != null){
			g2.setColor(Color.green);
			g2.drawLine(perceptron.getStartPoint().x,
					perceptron.getStartPoint().y,
					perceptron.getEndPoint().x,
					perceptron.getEndPoint().y);
		}
	}

	public ArrayList<Point> getPoints() {
		return selectedPoints;
	}

	public boolean isDrawVector() {
		return drawVector;
	}

	public void setDrawVector(boolean drawVector) {
		this.drawVector = drawVector;
	}

	public Perceptron getPerceptron() {
		return perceptron;
	}

	public void setPerceptron(Perceptron perceptron) {
		this.perceptron = perceptron;
	}
}
