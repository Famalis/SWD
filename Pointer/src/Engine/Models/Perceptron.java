/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Models;

import GUI.Easel;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Perceptron {

	private Point startPoint;
	private Point endPoint;
	private double threshold;
	private double errorThreshold;
	private double[] weights;
	private double alpha;
	private final int numOfWeights = 2;
	private double currentError = 0;
	private double currentErrorSet = 0;

	public Perceptron() {
		super();
		startPoint = null;
		endPoint = null;
		threshold = 0.0;
		errorThreshold = 0.0;
		weights = new double[numOfWeights];
		for (int i = 0; i < numOfWeights; i++) {
			weights[i] = Math.random();
		}
		alpha = 0.0;
	}

	public void learn(ArrayList<Point> learningSet) {
		
	}
	
	public void learnOne(Point p) {
		
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

	public double getThreshold() {
		return threshold;
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public double[] getWeights() {
		return weights;
	}

	public void setWeights(double[] weights) {
		this.weights = weights;
	}

}
