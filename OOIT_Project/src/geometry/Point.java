package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;
	//private boolean selected;
		
	public Point() {
	}
		
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
		
	public Point(int x, int y, boolean selected) {
		this(x, y);
		this.selected = selected;
	}

	public double distance(int x, int y) {
		int dx = this.x - x;
		int dy = this.y - y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point temp = (Point) obj;
			if (x == temp.x && y == temp.y) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(x + 2, y, x - 2, y);
		g.drawLine(x, y + 2, x, y - 2);
		if(selected) {
			g.drawRect(this.x-3, this.y-3, 6, 6);
		}
	}
	
	@Override
	public void moveOn(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveBy(int bx, int by) {
		this.x = x + bx;
		this.y = y + by;
	}
	
	public boolean contains(int x, int y) {
		return distance(x, y) <3;
	}
	
	/*public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}*/
	
	//getteri i setteri
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	

	
}

