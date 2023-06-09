package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable {

	protected boolean selected;
	private Color c;
	
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
	public Shape() {	
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}

	public abstract boolean contains(int x, int y);
	
	public abstract void draw(Graphics g);
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
