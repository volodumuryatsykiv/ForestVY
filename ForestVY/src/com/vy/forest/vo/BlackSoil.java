package com.vy.forest.vo;

import java.util.ArrayList;
import java.util.List;

import com.vy.forest.interfaces.Ground;
import com.vy.forest.interfaces.Tree;

public class BlackSoil extends Ground
{
	private float fertility;
	private String type;
	private final List<Tree> TreeList = new ArrayList<Tree>();

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
	public void addTree(Tree tree)
	{
		boolean isId = false;
		Tree tempTree = new Oak();

		for (int i = 0; i < TreeList.size(); i++)
		{
			tempTree = TreeList.get(i);

			if (tempTree.getId() == tree.getId())
			{
				isId = true;
			}
		}

		if (!isId)
		{
			TreeList.add(tree);
		} else
		{
			System.out.println("Tree whit this Id (" + tree.getId()
					+ ") is alreade exists");
		}
	}

	@Override
	public void addCoupleTree(Tree tree, int inId[])
	{
		boolean isId = false;
		Tree tempTree = new Oak();
		int n;

		if (TreeList.size() == 0)
		{
			tree = new Oak("Oak", inId[0]);
			TreeList.add(tree);
			if (inId[0] != inId[1])
			{
				tree = new Oak("Oak", inId[1]);
				TreeList.add(tree);
			} else
			{
				System.out.println("Leaf whit this Id (" + inId[1]
						+ ") is alreade exists");
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
						isId = true;
					}
				}
				if (!isId)
				{
					tree = new Oak("Oak", inId[i]);
					TreeList.add(tree);
				} else
				{
					System.out.println("Leaf whit this Id (" + inId[i]
							+ ") is alreade exists");
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
