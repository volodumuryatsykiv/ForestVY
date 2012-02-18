package com.vy.forest.abs;

import java.util.ArrayList;

public abstract class Tree
{
	public abstract void addLeaf(ArrayList<Leaf> leaf);

	public abstract void addCoupleLeaf(ArrayList<Leaf> leaf);

	public abstract void removeAllLeaf();

	public abstract void removeLeaf(int id);

	public abstract int getId();

	public abstract int getLeafCount();

	public abstract Leaf getLeaf(int i);

	public abstract void draw();
}
