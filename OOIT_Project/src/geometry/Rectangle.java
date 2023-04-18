package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape {

	public Point upperLeft;
	public int width;
	public int height;
	//public boolean selected;
	
	public Rectangle() {
	}

	public Rectangle(Point upperLeft, int width, int height) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeft, int width, int height, boolean selected) {
		this(upperLeft, width, height);
		this.selected = selected;
	}
	
	public int circumference() {
		return (width + height) * 2;
	}
	
	public int area() {
		return width * height;
	}
	
	@Override
	public String toString() {
		return "Upper left point: " + upperLeft + ", width: " + width + ", height: " + height;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle temp = (Rectangle) obj;
			if (upperLeft.equals(temp.upperLeft) && width == temp.width && height == temp.height) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		if(selected) {
			g.drawRect(upperLeft.getX()-3, upperLeft.getY()-3, 6, 6);
			g.drawRect(upperLeft.getX() + width - 3, upperLeft.getY() - 3, 6, 6);
			g.drawRect(upperLeft.getX()-3, upperLeft.getY() + height - 3, 6, 6);
			g.drawRect(upperLeft.getX() + width - 3, upperLeft.getY() + height - 3, 6, 6);
		}
	}
	
	@Override
	public void moveOn(int x, int y) {
		upperLeft.moveOn(x, y);
	}

	@Override
	public void moveBy(int bx, int by) {
		upperLeft.moveBy(bx, by);
	}
	
	public boolean contains(int x, int y) {
		boolean containsX = false;
		if (x >= upperLeft.getX() && x <= (upperLeft.getX() + width))
			containsX = true;
		boolean containsY = false;
		if (y >= upperLeft.getY() && y <= (upperLeft.getY() + height))
			containsY = true;
		return containsX && containsY;
	}
	
	//getteri i setteri
	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
