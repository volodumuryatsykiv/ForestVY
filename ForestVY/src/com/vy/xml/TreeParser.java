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
	private int leafWidth = 0;
	private int leafHeight = 0;
	private String currentLevel = "";
	private String value = new String();

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

	public void parseTree(String inQname)
	{
		if (inQname.equalsIgnoreCase("ID"))
		{

			System.out.println("ID : " + value);
			oak.setId(Integer.valueOf(value));

		} else if (inQname.equalsIgnoreCase("HEIGHT"))
		{

			System.out.println("TreeHeight : " + value);
			oak.setHeight(Integer.valueOf(value));

		} else if (inQname.equalsIgnoreCase("WIDTH"))
		{

			System.out.println("TreeWidth : " + value);
			oak.setWidth(Integer.valueOf(value));

		} else if (inQname.equalsIgnoreCase("AGE"))
		{

			System.out.println("TreeAge : " + value);
			oak.setAge(Integer.valueOf(value));

		} else if (inQname.equalsIgnoreCase("LEAFCOUNT"))
		{

			System.out.println("LeafCount : " + value);
			LeafCount = Integer.valueOf(value);
		}

		// TreeList.add(oak);
		// oak = new Oak();
	}

	public void parseLeaf(String inQname)
	{
		if (thisString.equalsIgnoreCase("Color"))
		{

			System.out.println("LeafColor :" + value);
			leafColor = value;
			oakLeaf.setColor(leafColor);

		} else if (thisString.equalsIgnoreCase("HEIGHT"))
		{
			System.out.println("LeafHeight : " + value);
			leafHeight = Integer.valueOf(value);
			oakLeaf.setHeight(leafHeight);

		} else if (thisString.equalsIgnoreCase("WIDTH"))
		{
			List<Leaf> tempLeafList = new ArrayList();

			System.out.println("LeafWidth : " + value);
			leafWidth = Integer.valueOf(value);
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

		// Tree tempOak = new Oak();
		// List<Leaf> tempLeafList = new ArrayList();
		// tempOak = TreeList.get(TreeList.size() - 1);
		// for (int i = tempOak.getId() + 1; i < LeafCount + tempOak.getId() +
		// 1; i++)
		// {
		// oakLeaf.setId(i);
		// LeafList.add(oakLeaf);
		// oakLeaf = new OakLeaf(leafColor, leafHeight, leafWidth);
		// }
		// tempLeafList.addAll(LeafList);
		// tempOak.setLeafList(tempLeafList);

	}

	@Override
	public void characters(char ch[], int start, int length)
			throws SAXException
	{
		value = new String(ch, start, length).trim();
		if (thisString.equalsIgnoreCase("Tree"))
		{
			currentLevel = "Tree";
		} else if (thisString.equalsIgnoreCase("Leaf"))
		{
			currentLevel = "Leaf";
		}

		if (currentLevel.equalsIgnoreCase("Tree"))
		{
			parseTree(thisString);
		} else if (currentLevel.equalsIgnoreCase("Leaf"))
		{
			parseLeaf(thisString);
		}
	}

}
