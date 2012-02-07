package com.vy.forest;

import com.vy.forest.VO.Oak;
import com.vy.forest.VO.OakLeaf;
import com.vy.forest.abs.Leaf;

public class Main
{

	public static void main(String[] args)
	{
		Oak oak = new Oak("Aok", "Leafs", 10f, false, 10); // if Tree oak -
															// method draw &
															// getLeafCount
															// aren't available

		Leaf[] leaf = new OakLeaf[0];

		oak.addCoupleLeaf(leaf);
		oak.addCoupleLeaf(leaf);

		System.out.println(oak.getLeafCount());// this method

		oak.draw(); // this method

		// I have some questions about this project... what questions - I call
		// or write you in skype about them
	}

}
