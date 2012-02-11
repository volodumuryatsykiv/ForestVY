package com.vy.forest.VO;

import com.vy.forest.abs.Leaf;
import com.vy.forest.abs.Tree;

public class Oak extends Tree
{
	private String name;
	private String view;
	private float height;
	private boolean isFruit;
	private int id = 0;
	private Leaf arr[] = new OakLeaf[0];

	public Oak(String inName, String inView, float inHeight, boolean isFruit,
			int inId)
	{
		this.name = inName;
		this.view = inView;
		this.height = inHeight;
		this.isFruit = isFruit;
		this.id = inId;
	}

	public Oak(String inName, String inView, float inHeight, int inId)
	{
		this(inName, inView, inHeight, false, inId);
	}

	public Oak(String inName, String inView, int inId)
	{
		this(inName, inView, 1f, false, inId);
	}

	public Oak(String inName, int inId)
	{
		this(inName, " ", 1f, false, inId);
	}

	public Oak()
	{
		this(" ", " ", 0f, false, 0);
	}

	public void setFruit(boolean fruity)
	{
		this.isFruit = fruity;
	}

	public boolean isFruit()
	{
		return this.isFruit;
	}

	public void setHeight(float inHeight)
	{
		this.height = inHeight;
	}

	public float getHeight()
	{
		return this.height;
	}

	public void setName(String inName)
	{
		this.name = inName;
	}

	public String getName()
	{
		return this.name;
	}

	public void setView(String inView)
	{
		this.view = inView;
	}

	public String getView()
	{
		return this.view;
	}

	public void setId(int inId)
	{
		this.id = inId;
	}

	@Override
	public int getId()
	{
		return this.id;
	}

	public int getLeafCount()
	{
		return arr.length;
	}

	@Override
	public void addLeaf(Leaf[] leaf)
	{
		Leaf tempArr[] = new OakLeaf[arr.length + 1];

		for (int i = 0; i < arr.length; i++)
		{
			tempArr[i] = arr[i];
		}

		arr = new OakLeaf[tempArr.length];

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = tempArr[i];
		}

		arr[tempArr.length - 1] = new OakLeaf("Green", tempArr.length - 1);
	}

	@Override
	public void addCoupleLeaf(Leaf leaf[])
	{
		Leaf tempArr[] = new OakLeaf[arr.length + 2];

		for (int i = 0; i < arr.length; i++)
		{
			tempArr[i] = arr[i];
		}

		arr = new OakLeaf[tempArr.length];

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = tempArr[i];
		}

		arr[tempArr.length - 2] = new OakLeaf("Green", tempArr.length - 2);

		arr[tempArr.length - 1] = new OakLeaf("Green", tempArr.length - 1);
	}

	@Override
	public void removeAllLeaf()
	{
		arr = new OakLeaf[0];
	}

	@Override
	public void removeLeaf(int id)
	{
		int leafCount = 0;
		boolean isRemoved = false;
		Leaf tempArr[] = new OakLeaf[arr.length];

		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i].getId() == id)
			{
				isRemoved = true;
			} else
			{
				tempArr[leafCount] = arr[i];
				leafCount++;
			}
		}

		arr = new OakLeaf[leafCount];

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = tempArr[i];
		}

		if (!isRemoved)
		{
			System.out.println("Leaf with id = " + id + " not found!!!");
			System.out.println();
		}
	}

	public void draw()
	{
		System.out.println("Name is " + this.name);
		System.out.println("View is " + this.view);
		System.out.println("Height is " + this.height);
		System.out.println("Fruity is " + this.isFruit);
		System.out.println("ID is " + this.id);

		System.out.println("Trere are that leaves on this tree: ");
		for (int i = 0; i < arr.length; i++)
		{
			arr[i].draw();
		}
	}
}
