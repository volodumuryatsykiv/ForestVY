package com.Vovan;

public class ConcreateLeaf extends Leaf
{
	private float size;

	public ConcreateLeaf(float size)
	{
		this.size = size;
	}

	public ConcreateLeaf()
	{
		this(0f);
	}

	public void setSize(float size)
	{
		this.size = size;
	}

	public float getSize()
	{
		return this.size;
	}

	public void draw()
	{
		System.out.println("Size is " + size);
	}
}
