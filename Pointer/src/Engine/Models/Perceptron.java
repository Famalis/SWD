/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine.Models;

import GUI.Easel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	

	public void learn(ArrayList<Point> trainingSet, Easel esael) {
		while(totalError > 0.1) {
			for (Point p : trainingSet) {
				learnOne(p);
				//startPoint.setX((int) (startPoint.getX()*weights[0]));
				esael.repaint();				
			}
		}
		//System.out.println(startPoint.getX()+" -> "+((int)(startPoint.getX()*weights[0])));
		startPoint.setX(((int)(startPoint.getX()*weights[0])));
		startPoint.setY(((int)(startPoint.getY()*weights[1])));
		
		endPoint.setX(((int)(endPoint.getX()*weights[0])));
		endPoint.setY(((int)(endPoint.getY()*weights[1])));
		/*
		startPoint.setXThroughAxisValue(startPoint.getAxisX()*weights[0]);
		startPoint.setYThroughAxisValue(startPoint.getAxisY()*weights[1]);
		
		endPoint.setXThroughAxisValue(endPoint.getAxisX()*weights[0]);
		endPoint.setYThroughAxisValue(endPoint.getAxisY()*weights[1]);
		*/
		
		System.out.println("Error "+totalError);
		System.out.println(Arrays.toString(weights));
		esael.repaint();
	}

	private void learnOne(Point p) {
		int output = p.getX() * weights[0] + p.getY() * weights[1] + weights[2] >= 0
				? 1 : 0;
		int error = p.getStatus() - output;
		totalError += Math.abs(error);
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
