package com.vy.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.vy.forest.interfaces.Leaf;
import com.vy.forest.interfaces.Tree;
import com.vy.forest.vo.Oak;
import com.vy.forest.vo.OakLeaf;

public class TreeParser extends DefaultHandler
{
	private Tree oak = new Oak();
	private Leaf oakLeaf = new OakLeaf();
	private int LeafCount = 0;
	private final List<Leaf> LeafList = new ArrayList<Leaf>();
	private final List<Tree> TreeList = new ArrayList<Tree>();
	private String thisString = "";
	private String leafColor = "";
	private boolean isTreeBegin = false;
	private boolean isLeafBegin = false;
	private int leafWidth = 0;
	private int leafHeight = 0;

	public List getOakList()
	{
		return TreeList;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException
	{
		thisString = qName;
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException
	{
		thisString = "";
	}

	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException
	{
		if (thisString.equalsIgnoreCase("Tree") && !isTreeBegin)
		{

			isTreeBegin = true;
			oak = new Oak();

		} else if (thisString.equalsIgnoreCase("Tree") && isTreeBegin)
		{

			isTreeBegin = false;

		} else if (thisString.equalsIgnoreCase("ID"))
		{

			System.out.println("ID : " + new String(ch, start, length));
			oak.setId(Integer.valueOf((new String(ch, start, length))));

		} else if (thisString.equalsIgnoreCase("HEIGHT") && !isLeafBegin)
		{

			System.out.println("TreeHeight : " + new String(ch, start, length));
			oak.setHeight(Integer.valueOf((new String(ch, start, length))));

		} else if (thisString.equalsIgnoreCase("WIDTH") && !isLeafBegin)
		{

			System.out.println("TreeWidth : " + new String(ch, start, length));
			oak.setWidth(Integer.valueOf((new String(ch, start, length))));

		} else if (thisString.equalsIgnoreCase("AGE"))
		{

			System.out.println("TreeAge : " + new String(ch, start, length));
			oak.setAge(Integer.valueOf((new String(ch, start, length))));

		} else if (thisString.equalsIgnoreCase("LEAFCOUNT"))
		{

			System.out.println("LeafCount : " + new String(ch, start, length));
			LeafCount = Integer.valueOf((new String(ch, start, length)));

		} else if (thisString.equalsIgnoreCase("Leaf") && !isLeafBegin)
		{

			isLeafBegin = true;
			oakLeaf = new OakLeaf();

		} else if (thisString.equalsIgnoreCase("Leaf") && isLeafBegin)
		{

			isLeafBegin = false;

		} else if (thisString.equalsIgnoreCase("Color"))
		{

			System.out.println("LeafColor :" + new String(ch, start, length));
			leafColor = new String(ch, start, length);
			oakLeaf.setColor(leafColor);

		} else if (thisString.equalsIgnoreCase("HEIGHT") && isLeafBegin)
		{
			System.out.println("LeafHeight : " + new String(ch, start, length));
			leafHeight = Integer.valueOf((new String(ch, start, length)));
			oakLeaf.setHeight(leafHeight);

		} else if (thisString.equalsIgnoreCase("WIDTH") && isLeafBegin)
		{
			List<Leaf> tempLeafList = new ArrayList();
			System.out.println("LeafWidth : " + new String(ch, start, length));
			leafWidth = Integer.valueOf((new String(ch, start, length)));
			oakLeaf.setWidth(leafWidth);

			for (int i = oak.getId() + 1; i < LeafCount + oak.getId() + 1; i++)
			{
				oakLeaf.setId(i);
				LeafList.add(oakLeaf);
				oakLeaf = new OakLeaf(leafColor, leafHeight, leafWidth);
			}

			tempLeafList.addAll(LeafList);
			oak.setLeafList(tempLeafList);
			TreeList.add(oak);
			oak = new Oak();
			oakLeaf = new OakLeaf();
			LeafList.clear();

		}

	}

}
