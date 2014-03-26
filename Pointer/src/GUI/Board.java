/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Engine.Models.Perceptron;
import Engine.Models.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author sergio
 */
public class Board extends JPanel {

	private Perceptron perceptron;
	private ArrayList<Point> group0;
	private ArrayList<Point> group1;

	public Board() {
		perceptron = new Perceptron();
		group0 = new ArrayList<>();
		group1 = new ArrayList<>();
	}

	public void initialization() {

	}

	public Perceptron getPerceptron() {
		return perceptron;
	}

	public void setPerceptron(Perceptron perceptron) {
		this.perceptron = perceptron;
	}

	public ArrayList<Point> getGroup0() {
		return group0;
	}

	public void setGroup0(ArrayList<Point> group0) {
		this.group0 = group0;
	}

	public ArrayList<Point> getGroup1() {
		return group1;
	}

	public void setGroup1(ArrayList<Point> group1) {
		this.group1 = group1;
	}
		
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		RenderingHints rh
				= new RenderingHints(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHints(rh);
		g2.setStroke(new BasicStroke(1));
		paintAxis(g2);
		paintPerceptron(g2);
		paintPoints(g2);

	}

	private void paintAxis(Graphics2D g2) {
		g2.setColor(Color.black);
		float dash1[] = {3.1f};
		BasicStroke dashed
				= new BasicStroke(1.0f,
						BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_MITER,
						10.0f, dash1, 0.0f);
		g2.setStroke(dashed);
		g2.drawLine(Point.getScreenWidth() / 2, 0, Point.getScreenWidth() / 2, Point.getScreenHeight());
		g2.drawLine(0, Point.getScreenHeight() / 2, Point.getScreenWidth(), Point.getScreenHeight() / 2);
	}

	private void paintPerceptron(Graphics2D g2) {
		if (perceptron.getEndPoint() != null) {
			g2.setStroke(new BasicStroke(1));
			g2.setColor(Color.green);
			g2.drawLine(perceptron.getStartPoint().getX(),
					perceptron.getStartPoint().getY(),
					perceptron.getEndPoint().getX(),
					perceptron.getEndPoint().getY());
		}
	}

	private void paintPoints(Graphics2D g2) {
		g2.setStroke(new BasicStroke(1));
		g2.setColor(Color.red);
		for (Point p : group0) {
			g2.drawLine(p.getX(), p.getY(), p.getX(), p.getY());
		}
		g2.setColor(Color.blue);
		for (Point p : group1) {
			g2.drawLine(p.getX(), p.getY(), p.getX(), p.getY());
		}
		
	}
}
