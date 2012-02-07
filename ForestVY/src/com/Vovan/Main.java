package com.Vovan;

public class Main
{

	public static void main(String[] args)
	{
		// Ground ground = new Ground(10.0f, "Chornozem");
		// Tree tree = new Tree(100, "ddd", "ddd");
		// Leaf leaf = new Leaf("Green");
		// ConcreateTree cTree = new ConcreateTree(true);
		// ConcreateLeaf cLeaf = new ConcreateLeaf(100f);
		//
		// tree.print();
		// tree.addLeaf(leaf);
		// tree.addCoupleLeaf(leaf);
		//
		// System.out.println(tree.getAmountLeaf());
		// tree.removeLeaf(2, leaf);
		// System.out.println(tree.getAmountLeaf());
		//
		// ground.addTree(tree);
		// ground.addCoupleTree(tree);
		//
		// System.out.println(ground.getAmountTree());
		//
		// ground.removeTree(1, tree);
		// System.out.println(ground.getAmountTree());
		//
		// cTree.draw();
		// cLeaf.draw();
		//
		// cTree.addLeaf(cLeaf);
		// System.out.println(cTree.getAmountLeaf());

		Oak oak = new Oak("Aok", "Leafs", 10f, false, 1);
		Leaf[] leaf = new Leaf[0];

		oak.addCoupleLeaf(leaf);
		System.out.println(oak.getLeafCount());

	}

}
