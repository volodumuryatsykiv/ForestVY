package com.Vovan;

public class ConcreateTree extends Tree
{
	private boolean isFruity;

	public ConcreateTree(boolean fruity)
	{
		this.isFruity = fruity;
	}

	public ConcreateTree()
	{
		this(false);
	}

	public void setFruity(boolean fruity)
	{
		this.isFruity = fruity;
	}

	public boolean getFruity()
	{
		return this.isFruity;
	}

	public void draw()
	{
		System.out.println("Fruity is " + isFruity);
	}
}
