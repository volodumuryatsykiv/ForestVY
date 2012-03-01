package com.vy.forest.vo;

import java.util.ArrayList;
import java.util.List;

import com.vy.forest.interfaces.Leaf;
import com.vy.forest.interfaces.Tree;

public class Oak extends Tree
{
	private String name;
	private String view;
	private float height;
	private boolean isFruit;
	private int id = 0;
	private final List<Leaf> LeafList = new ArrayList<Leaf>();

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
		boolean isId = false;
		Leaf tempLeaf = new OakLeaf();

		for (int i = 0; i < LeafList.size(); i++)
		{
			tempLeaf = LeafList.get(i);

			if (tempLeaf.getId() == leaf.getId())
			{
				isId = true;
			}
		}

		if (!isId)
		{
			LeafList.add(leaf);
		} else
		{
			System.out.println("Leaf whit this Id (" + leaf.getId()
					+ ") is alreade exists");
		}
	}

	@Override
	public void addCoupleLeaf(Leaf leaf, int inId[])
	{
		boolean isId = false;
		Leaf tempLeaf = new OakLeaf();
		int n;

		if (LeafList.size() == 0)
		{
			leaf = new OakLeaf("Green", inId[0]);
			LeafList.add(leaf);
			if (inId[0] != inId[1])
			{
				leaf = new OakLeaf("Green", inId[1]);
				LeafList.add(leaf);
			} else
			{
				System.out.println("Leaf whit this Id (" + inId[1]
						+ ") is alreade exists");
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
						isId = true;
					}
				}
				if (!isId)
				{
					leaf = new OakLeaf("Green", inId[i]);
					LeafList.add(leaf);
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

		System.out.println("Name is " + this.name);
		System.out.println("View is " + this.view);
		System.out.println("Height is " + this.height);
		System.out.println("Fruity is " + this.isFruit);
		System.out.println("ID is " + this.id);

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
