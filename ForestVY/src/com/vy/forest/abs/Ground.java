package com.vy.forest.abs;

import java.util.ArrayList;

public abstract class Ground
{
	public abstract void addTree(ArrayList<Tree> list);

	public abstract void addCoupleTree(ArrayList<Tree> list);

	public abstract void removeAllTree();

	public abstract void removeTree(int id);

	public abstract void draw();

	public abstract int getTreeCount();

	public abstract Tree getTree(int k);
}
