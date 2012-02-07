package com.vy.forest.VO;

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

	public void addTree(Tree tree)
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

		arr[tempArr.length - 1] = tree;
	}

	public void addCoupleTree(Tree tree)
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

		arr[tempArr.length - 2] = tree;
		arr[tempArr.length - 1] = tree;
	}

	public void removeAllTree()
	{
		arr = new Tree[0];
	}

	public void removeTree(int id)
	{
		int j = 0;
		Tree tempArr[] = new Tree[arr.length - 1];

		if (id > arr.length)
		{
			System.out.println("false!!!");
		} else
		{
			for (int i = 0; i < arr.length; i++)
			{
				if (i != id - 1)
				{
					tempArr[j] = arr[i];
					j++;
				}
			}

			arr = new Tree[tempArr.length];

			for (int i = 0; i < arr.length; i++)
			{
				arr[i] = tempArr[i];
			}
		}
	}

	public int getAmountTree()
	{
		return this.arr.length;
	}

	public void print()
	{
		System.out.println("Ground: type - " + type + ", fertility - "
				+ fertility + ".");
	}
}
