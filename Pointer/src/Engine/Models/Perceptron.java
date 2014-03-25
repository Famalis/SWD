/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine.Models;

import Engine.Models.Point;

/**
 *
 * @author sergio
 */
public class Perceptron {
	
	private Point startPoint;
	private Point endPoint;
	
	public Perceptron() {
		super();
		startPoint = null;
		endPoint = null;
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
