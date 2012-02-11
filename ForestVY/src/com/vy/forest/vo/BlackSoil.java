package com.vy.forest.vo;

import com.vy.forest.abs.Ground;
import com.vy.forest.abs.Tree;

public class BlackSoil extends Ground
{
	private float fertility;
	private String type;
	private Tree arr[] = new Tree[0];

	public BlackSoil(float fertility, String type)
	{
		this.fertility = fertility;
		this.type = type;
	}

	public BlackSoil()
	{
		this(0, "");
	}

	public void setFercility(float theFercility)
	{
		this.fertility = theFercility;
	}

	public float getFercility()
	{
		return this.fertility;
	}

	public void setType(String theType)
	{
		this.type = theType;
	}

	public String getType()
	{
		return this.type;
	}

	@Override
	public void addTree(Tree[] tree)
	{
		Tree tempArr[] = new Tree[arr.length + 1];

		for (int i = 0; i < arr.length; i++)
		{
			tempArr[i] = arr[i];
		}

		arr = new Tree[tempArr.length];

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = tempArr[i];
		}

		arr[tempArr.length - 1] = new Oak("Oak", "Leafs", 10.0f, false,
				tempArr.length - 1);
	}

	@Override
	public void addCoupleTree(Tree[] tree)
	{
		Tree tempArr[] = new Tree[arr.length + 2];

		for (int i = 0; i < arr.length; i++)
		{
			tempArr[i] = arr[i];
		}

		arr = new Tree[tempArr.length];

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = tempArr[i];
		}

		arr[tempArr.length - 2] = new Oak("Oak", "Leafs", 10.0f, false,
				tempArr.length - 2);
		arr[tempArr.length - 1] = new Oak("Oak", "Leafs", 10.0f, false,
				tempArr.length - 1);

		tree = new Oak[arr.length];

		for (int i = 0; i < arr.length; i++)
		{
			tree[i] = arr[i];
		}
	}

	@Override
	public void removeAllTree()
	{
		arr = new Tree[0];
	}

	@Override
	public void removeTree(int id)
	{
		int treeCount = 0;
		boolean isRemoved = false;
		Tree tempArr[] = new Tree[arr.length];

		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i].getId() == id)
			{
				isRemoved = true;
			}
			{
				tempArr[treeCount] = arr[i];
				treeCount++;
			}
		}

		arr = new Tree[treeCount];

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

	public int getAmountTree()
	{
		return this.arr.length;
	}

	@Override
	public Tree getTree(int k)
	{
		return arr[k];
	}

	@Override
	public int getTreeCount()
	{
		return arr.length;
	}

	@Override
	public void draw()
	{
		System.out.println("Amount tree = " + arr.length);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println("Tree id = " + arr[i].getId());
		}
	}
}
