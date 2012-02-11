package com.vy.forest;

import com.vy.forest.VO.BlackSoil;
import com.vy.forest.VO.Oak;
import com.vy.forest.VO.OakLeaf;
import com.vy.forest.abs.Ground;
import com.vy.forest.abs.Leaf;
import com.vy.forest.abs.Tree;

public class Main
{

	public static void main(String[] args)
	{
		Tree[] oak = new Oak[0];
		Leaf[] oakLeaf = new OakLeaf[0];

		Ground ground = new BlackSoil();

		ground.addCoupleTree(oak);

		ground.draw();

		oak[0].addCoupleLeaf(oakLeaf);
		oak[0].addCoupleLeaf(oakLeaf);

		// System.out.println(oak.getLeafCount());// this method

		// oak.draw(); // this method

		System.out.println("After removal: ");
		System.out.println();
		oak[0].removeLeaf(5);
		oak[0].draw();
	}
}
