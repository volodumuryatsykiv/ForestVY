package com.vy.forest.interfaces;

import java.util.List;

public abstract class Ground
{
	public abstract void addTree(Tree tree);

	public abstract void addCoupleTree(Tree tree, int inID[]);

	public abstract void removeAllTree();

	public abstract void removeTree(int id);

	public abstract void draw();

	public abstract void setTreeList(List<Tree> inTreeList);

	public abstract int getTreeCount();

	public abstract Tree getTree(int k);
}
