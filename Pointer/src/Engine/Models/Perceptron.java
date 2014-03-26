/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Models;

/**
 *
 * @author sergio
 */
public class Perceptron {

	double[] weights;
	double learningRate;
	double totalError;
	double alpha;
	
	private Point startPoint, endPoint;

	public Perceptron() {
		super();
		startPoint = null;
		endPoint = null;
		weights = new double[2];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = Math.random();
		}
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
