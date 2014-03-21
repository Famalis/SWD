/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine;

import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class Operations {
	
	private double wx=0.0, wy=0.0, d=0.1;

	public double getWx() {
		return wx;
	}

	public void setWx(double wx) {
		this.wx = wx;
	}

	public double getWy() {
		return wy;
	}

	public void setWy(double wy) {
		this.wy = wy;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}
	
	public ArrayList<Point> divideIntoGroup(ArrayList<Point> points, double d1, double d2) {
		ArrayList<Point> group = new ArrayList<>();
		for (Point p : points) {
			//double val = (Math.abs(p.getAxisX()+Math.abs(p.getAxisY())));
			//double val = Math.abs(p.getAxisX()+p.getAxisY());
			double val = p.getAxisX();
			if((p.getAxisX()<=d2 && p.getAxisX()>d1)
					&& (p.getAxisY()<=d2 && p.getAxisY()>d1)) {
				group.add(p);
				//System.out.println(p+" ; "+p.axisString());
			}
		}
		return group;
	}
	
}
