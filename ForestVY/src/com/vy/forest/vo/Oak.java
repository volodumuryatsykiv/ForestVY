package com.vy.forest.vo;

import java.util.ArrayList;
import java.util.List;

import com.vy.forest.interfaces.Leaf;
import com.vy.forest.interfaces.Tree;

public class Oak extends Tree
{
	private int height;
	private int width;
	private int age;
	private int id = 0;
	private List<Leaf> LeafList = new ArrayList<Leaf>();

	public Oak(int inId, int inHeight, int inWidth, int inAge)
	{
		this.id = inId;
		this.height = inHeight;
		this.width = inWidth;
		this.age = inAge;
	}

	public Oak(int inId)
	{
		this(0, 0, 0, inId);
	}

	public Oak()
	{
		this(0, 0, 0, 0);
	}

	@Override
	public void setLeafList(List<Leaf> inLeafList)
	{
		this.LeafList = inLeafList;
	}

	@Override
	public void setWidth(int inWidth)
	{
		this.width = inWidth;
	}

	@Override
	public float getWidth()
	{
		return this.width;
	}

	@Override
	public void setHeight(int inHeight)
	{
		this.height = inHeight;
	}

	@Override
	public float getHeight()
	{
		return this.height;
	}

	@Override
	public void setAge(int inAge)
	{
		this.age = inAge;
	}

	@Override
	public int getAge()
	{
		return this.age;
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

	@Override
	public int getLeafCount()
	{
		return LeafList.size();
	}

	@Override
	public Leaf getLeaf(int i)
	{
		return LeafList.get(i);
	}

	@Override
	public void addLeaf(Leaf leaf)
	{
		boolean isLeafExist = false;
		Leaf tempLeaf = new OakLeaf();

		for (int i = 0; i < LeafList.size(); i++)
		{
			tempLeaf = LeafList.get(i);

			if (tempLeaf.getId() == leaf.getId())
			{
				isLeafExist = true;
			}
		}

		if (!isLeafExist)
		{
			LeafList.add(leaf);
		} else
		{
			System.out.println("Leaf with this Id (" + leaf.getId()
					+ ") is already exists");
		}
	}

	@Override
	public void addCoupleLeaf(Leaf leaf, int inId[])
	{
		boolean isLeafExist = false;
		Leaf tempLeaf = new OakLeaf();
		int n;

		if (LeafList.size() == 0)
		{
			leaf = new OakLeaf(inId[0]);
			LeafList.add(leaf);
			if (inId[0] != inId[1])
			{
				leaf = new OakLeaf(inId[1]);
				LeafList.add(leaf);
			} else
			{
				System.out.println("Leaf with this Id (" + inId[1]
						+ ") is already exists");
			}
		} else
		{
			n = LeafList.size();
			for (int i = 0; i < inId.length; i++)
			{
				for (int j = 0; j < n; j++)
				{
					tempLeaf = LeafList.get(j);

					if (tempLeaf.getId() == inId[i])
					{
						isLeafExist = true;
					}
				}
				if (!isLeafExist)
				{
					leaf = new OakLeaf(inId[i]);
					LeafList.add(leaf);
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
	public void removeAllLeaf()
	{
		LeafList.clear();
	}

	@Override
	public void removeLeaf(int id)
	{
		boolean isRemoved = false;
		Leaf tempLeaf = new OakLeaf();

		for (int i = 0; i < LeafList.size(); i++)
		{
			tempLeaf = LeafList.get(i);

			if (tempLeaf.getId() == id)
			{
				isRemoved = true;
				LeafList.remove(i);
			}
		}

		if (!isRemoved)
		{
			System.out.println("Leaf with id = " + id + " not found!!!");
			System.out.println();
		}
	}

	@Override
	public void draw()
	{
		Leaf tempLeaf = new OakLeaf();

		System.out.println("ID is " + this.id);
		System.out.println("Height is " + this.height);
		System.out.println("Width is " + this.width);
		System.out.println("Age is " + this.age);

		System.out.println("There are that leaves on this tree: ");

		if (LeafList.size() == 0)
		{
			System.out.println("No leaf in this tree");
		} else
		{
			for (int i = 0; i < LeafList.size(); i++)
			{
				tempLeaf = LeafList.get(i);
				tempLeaf.draw();
			}
		}
	}
}
