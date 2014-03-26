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
public class Point {
	
	private int x,y,status;
	
	private static int screenWidth, screenHeight;

	public static int getScreenWidth() {
		return screenWidth;
	}

	public static void setScreenWidth(int screenWidth) {
		Point.screenWidth = screenWidth;
	}

	public static int getScreenHeight() {
		return screenHeight;
	}

	public static void setScreenHeight(int screenHeight) {
		Point.screenHeight = screenHeight;
	}
	
	public Point() {
		super();
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, int status) {
		this.x = x;
		this.y = y;
		this.status = status;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setXThroughAxisValue(double x) {
		this.x = (int) (x + screenWidth/2);
	}
	
	public void setYThroughAxisValue(double y) {
		this.y = (int) (y + screenWidth/2);
	}
	
	public double getAxisX() {
		return x - (screenWidth/2);
	}
	
	public double getAxisY() {
		return y - (screenHeight/2);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
