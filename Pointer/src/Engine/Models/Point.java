/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Engine.Models;

/**
 *
 * @author Sergio
 */
public class Point {
	
	public int x,y;
	public boolean status;
	public static int screenWidth, screenHeight;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.status = false;
	}
	
	public Point(int x, int y, boolean status) {
		super();
		this.x = x;
		this.y = y;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return x+", "+y;
	}
	
	public String axisString() {
		return getAxisX()+", "+getAxisY();
	}
	/**
	 * Zwraca współrzędną x jak na układzie współrzędnych (punkt 0 na środku)
	 * @return 
	 */
	public double getAxisX() {
		return x-(screenWidth/2);
	}
	
	/**
	 * Zwraca współrzędną y jak na układzie współrzędnych (punkt 0 na środku)
	 * @return 
	 */
	public double getAxisY() {
		return -1*(y-(screenHeight/2));
	}
	
	public void setAxisX(int x) {
		this.x = x + (screenWidth/2);
	}
	
	public void setAxisY(int y) {
		this.y = -1*(y+(screenHeight/2));
	}
	
	public boolean equals(Point p) {
		return p.x == x && p.y == y;
	}
}
