/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Engine.Models.Cluster;
import Engine.Operations;
import Engine.Models.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Sergio
 */
public class Board extends JPanel {

	private static final Logger LOGGER = Logger.getLogger(Board.class.getCanonicalName());

	private int width, height;
	private ArrayList<Point> points = new ArrayList<>();
	private ArrayList<Point> areaPoints = new ArrayList<>();
	private HashMap<Color, ArrayList<Point>> groups = new HashMap<>();
	private ArrayList<Cluster> clusters = new ArrayList<>();

	public Board() {
		super();
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
		paintPoints(g2, points);
		paintAxes(g2);
		/*
		for (Cluster c : clusters) {
			g2.setColor(c.color);
			paintPoints(g2, c.points);
		}
		*/
		paintClusters(g2);
		g2.setColor(Color.black);
		//System.out.println(aGroup.size());

	}

	/**
	 * Rysuje osie
	 *
	 * @param g2
	 */
	private void paintAxes(Graphics2D g2) {
		float[] dash = {2f, 0f, 2f};
		BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 1.0f, dash, 2f);
		g2.setStroke(bs1);
		g2.drawLine(width / 2, 0, width / 2, height);
		g2.drawLine(0, height / 2, width, height / 2);
	}

	/**
	 * Rysuje linię międy dwoma punktami, które podał użytkownik. Linia będzie
	 * promieniem okręgu.
	 *
	 * @param g2
	 */
	private void drawRange(Graphics2D g2) {
		float[] dash = {6f, 0f, 6f};
		BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 1.0f, dash, 2f);
		g2.setStroke(bs1);
		g2.drawLine(points.get(0).x, points.get(0).y, points.get(1).x, points.get(1).y);
		drawAreaCircle(g2);
	}

	/**
	 * Rysuje okrąg na podstawie punktów wyranych przez użytkownika.
	 *
	 * @param g2
	 */
	public void drawAreaCircle(Graphics2D g2) {
		calcPointsInArea();
		int range = getAreaCircleRadius();
		g2.setStroke(new BasicStroke(1));
		drawCircle(g2, points.get(0).x, points.get(0).y, (int) Math.floor(range));
		/*
		 for (Point p : areaPoints) {
		 g2.setColor(Color.LIGHT_GRAY);
		 g2.drawLine(p.x, p.y, p.x, p.y);
		 }
		 g2.setColor(Color.BLACK);
		 */

	}

	/**
	 * Rysuje punkty z listy punktów.
	 *
	 * @param g2
	 */
	private void paintPoints(Graphics2D g2, ArrayList<Point> pointsList) {
		g2.setStroke(new BasicStroke(1));
		for (Point p : pointsList) {
			g2.drawLine(p.x, p.y, p.x, p.y);
		}
		if (pointsList == points && pointsList.size() < 2) {
			clusters.clear();
		}
		if (pointsList == points && pointsList.size() > 1) {
			drawRange(g2);
		}
	}

	private void paintClusters(Graphics2D g2) {
		g2.setStroke(new BasicStroke(1));
		for (Cluster currentCluster : clusters) {
			for (Point p : currentCluster.points) {
				g2.setColor(currentCluster.color);
				/*
				for(Cluster otherCluster : clusters) {
					if(currentCluster!=otherCluster
							&& otherCluster.containsPoint(p)) {
						Color newColor = new Color(
								currentCluster.color.getRed()+otherCluster.color.getRed(), 
								currentCluster.color.getGreen()+otherCluster.color.getGreen(), 
								currentCluster.color.getBlue()+otherCluster.color.getBlue(), 
								50);
						g2.setColor(newColor);
					}
				}
				*/
				g2.drawLine(p.x, p.y, p.x, p.y);
			}
		}
	}

	/**
	 * Metoda do rysowania okręgu na podstawie punktu środka i promienia.
	 *
	 * @param cg
	 * @param xCenter
	 * @param yCenter
	 * @param r
	 */
	private void drawCircle(Graphics2D cg, int xCenter, int yCenter, int r) {
		cg.drawOval(xCenter - r, yCenter - r, 2 * r, 2 * r);
	}

	/**
	 * Metoda do obliczania odległości między dwoma punktami
	 *
	 * @param p1
	 * @param p2
	 * @return
	 */
	private int calcIntDistanceBetweenPoints(Point p1, Point p2) {
		return (int) Math.floor(Math.sqrt(
				(p1.x - p2.x) * (p1.x - p2.x)
				+ (p1.y - p2.y) * (p1.y - p2.y)));
	}

	/**
	 * Metoda zwraca odległość między punktami wybranymi przez użytkownika.
	 *
	 * @return
	 */
	public int getAreaCircleRadius() {
		return calcIntDistanceBetweenPoints(points.get(0), points.get(1));
	}

	/**
	 * Wypełnia <code>areaPoints</code> punktami zwawrtymi w okręgu wybranym
	 * przez użytkownika.
	 */
	private void calcPointsInArea() {
		areaPoints.clear();
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				Point p = new Point(x, y);
				if (calcIntDistanceBetweenPoints(
						points.get(0), p) <= getAreaCircleRadius()) {
					areaPoints.add(p);
					//LOGGER.info(p.toString());
				}
			}
		}
		Operations o = new Operations();
		Cluster c1 = new Cluster();
		Cluster c2 = new Cluster();
		Cluster c3 = new Cluster();
		c1.color = new Color(255, 0, 0, 50);
		c1.points.addAll(o.divideIntoGroup(areaPoints, 10.0, 60.0));
		c2.color = new Color(0, 0, 255, 50);
		c2.points.addAll(o.divideIntoGroup(areaPoints, 80.0, 160.0));
		c3.color = new Color(0, 255, 0, 50);
		c3.points.addAll(o.divideIntoGroup(areaPoints, 40.0, 120.0));
		clusters.add(c1);
		clusters.add(c2);
		clusters.add(c3);
		Collections.sort(clusters);
	}

	/**
	 * Zwraca punkty wybrane przez użytkownika.
	 *
	 * @return
	 */
	public ArrayList<Point> getPoints() {
		return points;
	}

	/**
	 * Zwraca punkty zawarte w kręgu stworzonym przez użytkownika.
	 *
	 * @return
	 */
	public ArrayList<Point> getAreaPoints() {
		return areaPoints;
	}

}
