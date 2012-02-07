package com.Vovan;

public class OakLeaf extends Leaf
{
	private String leafColor = "";
	private float size;
	private int id = 0;

	public OakLeaf(String inLeafColor, float inSize, int inId)
	{
		this.leafColor = inLeafColor;
		this.size = inSize;
		this.id = inId;
	}

	public OakLeaf(String inLeafColor, int inId)
	{
		this(inLeafColor, 1f, inId);
	}

	public OakLeaf()
	{
		this(" ", 0f, 0);
	}

	public void setSize(float size)
	{
		this.size = size;
	}

	public float getSize()
	{
		return this.size;
	}

	public void setLeafColor(String inLeafColor)
	{
		this.leafColor = inLeafColor;
	}

	public String getLeafColor()
	{
		return this.leafColor;
	}

	@Override
	public void draw()
	{
		System.out.println("Color is " + this.leafColor);
		System.out.println("Size is " + this.size);
		System.out.println("ID is " + this.id);
	}
}
