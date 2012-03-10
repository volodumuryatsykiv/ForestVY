package com.vy.forest.interfaces;

public abstract class Leaf
{
	// I really don't know, what method add to this class
	public abstract void draw();

	public abstract int getId();

	public abstract int getHeight();

	public abstract int getWidth();

	public abstract String getColor();

	public abstract void setHeight(int inHeight);

	public abstract void setWidth(int inWidth);

	public abstract void setColor(String inColor);

	public abstract void setId(int inId);
}
