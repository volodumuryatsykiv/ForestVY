package com.vy.forest.interfaces;

public abstract class Tree
{
	public abstract void addLeaf(Leaf leaf);

	public abstract void addCoupleLeaf(Leaf leaf, int inId[]);

	public abstract void removeAllLeaf();

	public abstract void removeLeaf(int id);

	public abstract int getId();

	public abstract void setId(int inId);

	public abstract int getLeafCount();

	public abstract Leaf getLeaf(int i);

	public abstract void draw();
}
