package com.vy.forest.vo;

import com.vy.forest.interfaces.Leaf;

public class OakLeaf extends Leaf
{
	private String color = "";
	private int height;
	private int width;
	private int id = 0;

	public OakLeaf(String inColor, int inHeight, int inWidth, int inId)
	{
		this.color = inColor;
		this.height = inHeight;
		this.width = inWidth;
		this.id = inId;
	}

	public OakLeaf(String inColor, int inHeight, int inWidth)
	{
		this(inColor, inHeight, inWidth, 0);
	}

	public OakLeaf(int inId)
	{
		this("Green", 1, 1, inId);
	}

	public OakLeaf()
	{
		this(" ", 0, 0, 1);
	}

	@Override
	public void setHeight(int inHeight)
	{
		this.height = inHeight;
	}

	@Override
	public int getHeight()
	{
		return this.height;
	}

	@Override
	public void setWidth(int inWidth)
	{
		this.width = inWidth;
	}

	@Override
	public int getWidth()
	{
		return this.width;
	}

	@Override
	public void setColor(String inColor)
	{
		this.color = inColor;
	}

	@Override
	public String getColor()
	{
		return this.color;
	}

	@Override
	public void setId(int inId)
	{
		this.id = inId;
	}

	@Override
	public int getId()
	{
		return this.id;
	}

	public void setLeafColor(String inLeafColor)
	{
		this.color = inLeafColor;
	}

	public String getLeafColor()
	{
		return this.color;
	}

	@Override
	public void draw()
	{
		System.out.println("ID is " + this.id);
		System.out.println("Color is " + this.color);
		System.out.println("Height is " + this.height);
		System.out.println("width is " + this.width);
		System.out.println();
	}
}
