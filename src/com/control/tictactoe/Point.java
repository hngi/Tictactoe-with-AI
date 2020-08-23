package com.control.tictactoe;

public class Point {
	public int x, y;
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}       
	
	
	@Override
	public String toString() {
		return "Score [x=" + x + ", y=" + y + "]";
	}

}
