/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class Cluster implements Comparable{

	public ArrayList<Point> points;
	public Color color;

	public Cluster(){
		super();
		points = new ArrayList<>();
	}

	@Override
	public int compareTo(Object o) {
		Cluster co = (Cluster) o;
		return co.points.size() - this.points.size();
	}
	
	public boolean containsPoint(Point point) {
		for (Point p : points) {
			if(p.equals(p)) {
				return true;
			}
		}
		return false;
	}

}
