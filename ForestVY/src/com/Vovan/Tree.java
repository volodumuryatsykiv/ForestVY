package com.Vovan;

abstract class Tree
{
	public abstract void addLeaf(Leaf leaf);

	public abstract void addCoupleLeaf(Leaf leaf[]);

	public abstract void removeAllLeaf();

	public abstract void removeLeaf(int id);
}
