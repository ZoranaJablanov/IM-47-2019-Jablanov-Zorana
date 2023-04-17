package geometry;

import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	//private boolean selected;
	
	public Line() {
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.selected = selected;
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	@Override
	public String toString() {
		return startPoint + " --> " + endPoint;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line temp = (Line) obj;
			return startPoint.equals(temp.startPoint) && endPoint.equals(temp.endPoint);
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), 
				startPoint.getY(),
				endPoint.getX(), 
				endPoint.getY());
		if(selected) {
			g.drawRect(this.getStartPoint().getX()-3, this.getStartPoint().getY()-3, 6, 6);
			g.drawRect(this.getEndPoint().getX()-3, this.getEndPoint().getY()-3, 6, 6);
		}
	}
	
	@Override
	public void moveOn(int x, int y) {
		
	}

	@Override
	public void moveBy(int bx, int by) {
		startPoint.moveBy(bx, by);
		endPoint.moveBy(bx, by);
	}

	public boolean contains(int x, int y) {
		return (length() - (this.startPoint.distance(x,y) + this.endPoint.distance(x,y))) <3;
	}
	
	/*public boolean contains(Point p) {
		return contains(p.getX(),p.getY());
	}*/
	
	//getteri i setteri
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
