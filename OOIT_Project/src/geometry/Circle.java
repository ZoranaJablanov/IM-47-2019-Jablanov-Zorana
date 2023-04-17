package geometry;

import java.awt.Graphics;

public class Circle extends Shape {

	protected Point center;
	protected int radius;
	//protected boolean selected;
	
	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}
	
	public double area() {
		return radius * radius * Math.PI;
	}
	
	public double circumference() {
		return 2 * radius * Math.PI;
	}
	
	@Override
	public String toString() {
		return "Center: " + center + ", radius: " + radius;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle temp = (Circle) obj;
			if (center.equals(temp.center) && radius == temp.radius) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX()-radius, center.getY()-radius,
				radius*2, radius*2);
		if(selected) {
			g.drawRect(center.getX() - radius - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() + radius - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() - radius - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() + radius - 3, 6, 6);
		}
	}
	
	@Override
	public void moveOn(int x, int y) {
		center.moveOn(x, y);
	}

	@Override
	public void moveBy(int bx, int by) {
		center.moveBy(bx, by);
	}

	public boolean contains(int x, int y) {
		return (center.distance(x,y) <= radius);
	}
	
	/*public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}*/
	
	//getteri i setteri
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws Exception {
		if(radius <= 0) {
			throw new Exception("Unet je los radius.");
		}else {
			this.radius = radius;
		}
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
