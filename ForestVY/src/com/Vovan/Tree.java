package com.Vovan;

//Tree.class
//-basic properties
//-basic methods
//-add / remove leafs (Leaf.class)
//-remove all leafs (Leaf.class)
//-add a couple of leafs (Leaf.class)
public class Tree
{
	private float hight;
	private String view;
	private String name;
	private Leaf arr[] = new Leaf[0];

	public Tree(float hight, String view, String name)
	{
		this.hight = hight;
		this.view = view;
		this.name = name;
	}

	public Tree()
	{
		this(0, "", "");
	}

	public void setHight(float hight)
	{
		this.hight = hight;
	}

	public float getHight()
	{
		return this.hight;
	}

	public void setView(String theView)
	{
		this.view = theView;
	}

	public String getView()
	{
		return this.view;
	}

	public void setName(String theName)
	{
		this.name = theName;
	}

	public String getName()
	{
		return this.name;
	}

	public void print()
	{
		System.out.println("Tre: view - " + view + ", name - " + name
				+ ", hight - " + hight + ".");
	}

	public void addLeaf(Leaf leaf)
	{
		Leaf tempArr[] = new Leaf[arr.length + 1];

		for (int i = 0; i < arr.length; i++)
		{
			tempArr[i] = arr[i];
		}

		arr = new Leaf[tempArr.length];

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = tempArr[i];
		}

		arr[tempArr.length - 1] = leaf;
	}

	public void addCoupleLeaf(Leaf leaf)
	{
		Leaf tempArr[] = new Leaf[arr.length + 2];

		for (int i = 0; i < arr.length; i++)
		{
			tempArr[i] = arr[i];
		}

		arr = new Leaf[tempArr.length];

		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = tempArr[i];
		}

		arr[tempArr.length - 2] = leaf;
		arr[tempArr.length - 1] = leaf;
	}

	public void removeAllLeaf()
	{
		arr = new Leaf[0];
	}

	public void removeLeaf(int id, Leaf leaf)
	{
		int j = 0;
		Leaf tempArr[] = new Leaf[arr.length - 1];

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

			arr = new Leaf[tempArr.length];

			for (int i = 0; i < arr.length; i++)
			{
				arr[i] = tempArr[i];
			}
		}
	}

	public int getAmountLeaf()
	{
		return this.arr.length;
	}
}
