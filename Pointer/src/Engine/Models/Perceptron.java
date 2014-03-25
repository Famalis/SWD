/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine.Models;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Perceptron {
	
	private Point startPoint;
	private Point endPoint;
	private double threshold;
	private double[] weights;
	
	public Perceptron() {
		super();
		startPoint = null;
		endPoint = null;
		threshold = 0;
		weights = new double[4];
		weights[0] = 1.0;
		weights[1] = 1.0;
		weights[2] = 1.0;
		weights[3] = 1.0;
	}
	
	public void learn(ArrayList<Point> learningSet) {
		
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
}
