package com.vy.forest.interfaces;

import java.util.List;

public abstract class Tree
{
	public abstract void addLeaf(Leaf leaf);

	public abstract void addCoupleLeaf(Leaf leaf, int inId[]);

	public abstract void removeAllLeaf();

	public abstract void removeLeaf(int id);

	public abstract int getId();

	public abstract void setId(int inId);

	public abstract int getAge();

	public abstract void setAge(int inAge);

	public abstract void setHeight(int inHeight);

	public abstract float getHeight();

	public abstract void setWidth(int inWidth);

	public abstract float getWidth();

	public abstract int getLeafCount();

	public abstract Leaf getLeaf(int i);

	public abstract void setLeafList(List<Leaf> inLeafList);

	public abstract void draw();
}
