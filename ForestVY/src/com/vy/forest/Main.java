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

		oak = new Oak[ground.getTreeCount()];
		for (int i = 0; i < ground.getTreeCount(); i++)
		{
			oak[i] = ground.getTree(i);
		}

		System.out.println("Oak.length = " + oak.length);

		oak[1].addCoupleLeaf(oakLeaf);
		oak[1].addCoupleLeaf(oakLeaf);

		System.out.println("After removal: ");
		System.out.println();
		oak[1].removeLeaf(2);
		oak[1].draw();
	}
}
