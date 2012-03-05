package com.vy.forest.vo;

import java.util.ArrayList;
import java.util.List;

import com.vy.forest.interfaces.Ground;
import com.vy.forest.interfaces.Tree;

public class BlackSoil extends Ground
{
	private float fertility;
	private String type;
	private List<Tree> TreeList = new ArrayList<Tree>();

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
	public void setTreeList(List<Tree> inTreeList)
	{
		this.TreeList = inTreeList;
	}

	@Override
	public void addTree(Tree tree)
	{
		boolean isTreeExist = false;
		Tree tempTree = new Oak();

		for (int i = 0; i < TreeList.size(); i++)
		{
			tempTree = TreeList.get(i);

			if (tempTree.getId() == tree.getId())
			{
				isTreeExist = true;
			}
		}

		if (!isTreeExist)
		{
			TreeList.add(tree);
		} else
		{
			System.out.println("Tree with this Id (" + tree.getId()
					+ ") is already exists");
		}
	}

	@Override
	public void addCoupleTree(Tree tree, int inId[])
	{
		boolean isTreeExist = false;
		Tree tempTree = new Oak();
		int n;

		if (TreeList.size() == 0)
		{
			tree = new Oak(inId[0]);
			TreeList.add(tree);
			if (inId[0] != inId[1])
			{
				tree = new Oak(inId[1]);
				TreeList.add(tree);
			} else
			{
				System.out.println("Leaf with this Id (" + inId[1]
						+ ") is already exists");
			}
		} else
		{
			n = TreeList.size();
			for (int i = 0; i < inId.length; i++)
			{
				for (int j = 0; j < n; j++)
				{
					tempTree = TreeList.get(j);

					if (tempTree.getId() == inId[i])
					{
						isTreeExist = true;
					}
				}
				if (!isTreeExist)
				{
					tree = new Oak(inId[i]);
					TreeList.add(tree);
				} else
				{
					System.out.println("Leaf with this Id (" + inId[i]
							+ ") is already exists");
				}
				n++;
			}
		}
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
