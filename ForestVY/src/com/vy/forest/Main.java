package com.vy.forest;

import com.vy.forest.interfaces.Ground;
import com.vy.forest.interfaces.Leaf;
import com.vy.forest.interfaces.Tree;
import com.vy.forest.vo.BlackSoil;
import com.vy.forest.vo.Oak;
import com.vy.forest.vo.OakLeaf;

public class Main
{

	public static void main(String[] args)
	{
		Ground ground = new BlackSoil();
		Tree oak = new Oak();
		Leaf oakLeaf = new OakLeaf();

		System.out.println("Add 3 leaf");
		oak.addLeaf(oakLeaf);
		oak.addCoupleLeaf(oakLeaf);
		System.out.println("Count leaf = " + oak.getLeafCount());
		System.out.println();
		oak.draw();

		System.out.println("After removed leaf with 2 id: ");
		oak.removeLeaf(2);
		oak.draw();

		System.out.println("Removed all leaf: ");
		oak.removeAllLeaf();
		oak.draw();

		System.out.println();
		System.out.println();

		System.out.println("Ground: ");
		ground.addTree(oak);
		ground.addCoupleTree(oak);
		System.out.println("Count tree = " + ground.getTreeCount());
		ground.draw();

		System.out.println();
		System.out.println("After removed tree with 2 id: ");
		ground.removeTree(2);
		ground.draw();

		System.out.println();
		System.out.println("Removed all tree: ");
		ground.removeAllTree();
		ground.draw();
	}
}
