package com.vy.forest.interfaces;


public abstract class Ground
{
	public abstract void addTree(Tree tree);

	public abstract void addCoupleTree(Tree tree);

	public abstract void removeAllTree();

	public abstract void removeTree(int id);

	public abstract void draw();

	public abstract int getTreeCount();

	public abstract Tree getTree(int k);
}
