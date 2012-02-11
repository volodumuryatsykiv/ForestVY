package com.vy.forest.abs;

public abstract class Ground
{
	public abstract void addTree(Tree[] tree);

	public abstract void addCoupleTree(Tree tree[]);

	public abstract void removeAllTree();

	public abstract void removeTree(int id);

	public abstract void draw();
}
