package com.Vovan;

//-basic properties
//-basic methods
public class Leaf
{
	private String leafColor = "";

	public Leaf(String theLeafColor)
	{
		this.leafColor = theLeafColor;
	}

	public Leaf()
	{
		this("");
	}

	public void setLeafColor(String color)
	{
		this.leafColor = color;
	}

	public String getLeafColor()
	{
		return this.leafColor;
	}

	public void print()
	{
		System.out.println("Leaf is " + leafColor);
	}
}
