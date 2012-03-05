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
		// Random randId = new Random();
		// int[] ID = new int[2];
		//
		// System.out.println("Add 3 leaf");
		// oakLeaf = new OakLeaf(randId.nextInt(100000));
		// oak.addLeaf(oakLeaf);
		//
		// for (int i = 0; i < ID.length; i++)
		// {
		// ID[i] = randId.nextInt(100000);
		// }
		// oak.addCoupleLeaf(oakLeaf, ID);
		//
		// oakLeaf = new OakLeaf(10);
		// oak.addLeaf(oakLeaf);
		// System.out.println("Count leaf = " + oak.getLeafCount());
		// System.out.println();
		// oak.draw();
		//
		// System.out.println("After removed leaf with 10 id: ");
		// oak.removeLeaf(10);
		// oak.draw();
		//
		// System.out.println("After removed leaf with 1 id: ");
		// oak.removeLeaf(1);
		// oak.draw();
		//
		// System.out.println("Removed all leaf: ");
		// oak.removeAllLeaf();
		// oak.draw();
		//
		// System.out.println();
		// System.out.println();
		//
		// System.out.println("Ground: ");
		// oak.setId(13);
		// ground.addTree(oak);
		//
		// for (int i = 0; i < ID.length; i++)
		// {
		// ID[i] = randId.nextInt(100000);
		// }
		//
		// ground.addCoupleTree(oak, ID);
		// System.out.println("Count tree = " + ground.getTreeCount());
		// ground.draw();
		//
		// System.out.println();
		// System.out.println("After removed tree with 2 id: ");
		// ground.removeTree(2);
		// ground.draw();
		//
		// System.out.println();
		// System.out.println("After removed tree with 13 id: ");
		// ground.removeTree(13);
		// ground.draw();
		//
		// System.out.println();
		// System.out.println("Removed all tree: ");
		// ground.removeAllTree();
		// ground.draw();

		XMLReader reader = new XMLReader();
		reader.setOak();

		ground.setTreeList(reader.getOak());

		System.out.println();
		System.out.println();
	}
}
