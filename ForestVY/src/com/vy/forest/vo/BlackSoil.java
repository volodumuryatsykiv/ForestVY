package com.vy.forest.vo;

import java.util.ArrayList;

import com.vy.forest.abs.Ground;
import com.vy.forest.abs.Tree;

public class BlackSoil extends Ground
{
	private float fertility;
	private String type;
	private final ArrayList<Tree> TreeList = new ArrayList<Tree>();

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
	public void addTree(ArrayList<Tree> list)
	{
		Tree tempTree = new Oak("Oak", "Leafs", 10.0f, false,
				TreeList.size() + 1);

		list.add(tempTree);
		TreeList.add(tempTree);
	}

	@Override
	public void addCoupleTree(ArrayList<Tree> list)
	{
		Tree tempTree = new Oak("Oak", "Leafs", 10.0f, false,
				TreeList.size() + 1);

		list.add(tempTree);
		TreeList.add(tempTree);

		tempTree = new Oak("Oak", "Leafs", 10.0f, false, TreeList.size() + 1);

		list.add(tempTree);
		TreeList.add(tempTree);
	}

	@Override
	public void removeAllTree()
	{
		TreeList.clear();
	}

	@Override
	public void removeTree(int id)
	{
		boolean isRemoved = false;
		Tree tempTree = new Oak();

		for (int i = 0; i < TreeList.size(); i++)
		{
			tempTree = TreeList.get(i);
			if (tempTree.getId() == id)
			{
				isRemoved = true;
				TreeList.remove(i);
			}
		}

		if (!isRemoved)
		{
			System.out.println("Leaf with id = " + id + " not found!!!");
			System.out.println();
		}
	}

	@Override
	public Tree getTree(int k)
	{
		return TreeList.get(k);
	}

	@Override
	public int getTreeCount()
	{
		return TreeList.size();
	}

	@Override
	public void draw()
	{
		Tree tempTree = new Oak();

		if (TreeList.size() == 0)
		{
			System.out.println("In this ground no tree!!!");
		} else
		{
			System.out.println("Amount tree = " + TreeList.size());
			for (int i = 0; i < TreeList.size(); i++)
			{
				tempTree = TreeList.get(i);
				System.out.println("Tree id = " + tempTree.getId());
			}
		}
	}
}
