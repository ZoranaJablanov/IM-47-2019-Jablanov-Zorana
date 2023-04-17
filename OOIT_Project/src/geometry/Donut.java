package geometry;

import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;

	public Donut() {
		super();
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius,int innerRadius, boolean selected) {
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}
	
	@Override
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	@Override
	public double circumference() {
		return super.circumference() + 2 * innerRadius * Math.PI;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", inner radius: " + innerRadius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp = (Donut)obj;
			if(super.equals(new Circle(temp.getCenter(), temp.getRadius())) && innerRadius == temp.getInnerRadius()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius,
				innerRadius*2, innerRadius*2);
		if(selected) {
			g.drawRect(center.getX() - innerRadius - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() + innerRadius - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() - innerRadius - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() + innerRadius - 3, 6, 6);
		}
	}
	
	@Override
	public boolean contains(int x, int y) {
		return super.contains(x,y) && this.center.distance(x, y) >= innerRadius;
	}
	
	/*public boolean contains(Point p) {
		return contains(p.getX(),p.getY());
	}*/
	
	//getteri i setteri
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	
	
	
}
