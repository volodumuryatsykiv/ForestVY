package com.vy.forest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.vy.forest.interfaces.Leaf;
import com.vy.forest.interfaces.Tree;
import com.vy.forest.vo.Oak;
import com.vy.forest.vo.OakLeaf;

public class XMLReader
{
	private Tree oak = new Oak();
	private Leaf oakLeaf = new OakLeaf();
	private int LeafCount = 0;
	private final List<Leaf> LeafList = new ArrayList<Leaf>();
	private final List<Tree> TreeList = new ArrayList<Tree>();

	public List getOak()
	{
		return TreeList;
	}

	public void setOak()
	{
		try
		{

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler()
			{
				boolean isTreeBegin = false;
				boolean isLeafBegin = false;
				boolean isTreeId = false;
				boolean isTreeHeight = false;
				boolean isTreeWidth = false;
				boolean isTreeAge = false;
				boolean isLeafCount = false;
				boolean isLeafHeight = false;
				boolean isLeafWidth = false;
				boolean isLeafColor = false;
				String leafColor = "";
				int leafWidth = 0;
				int leafHeight = 0;

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException
				{
					if (qName.equalsIgnoreCase("TREE") && !isTreeBegin)
					{
						isTreeBegin = true;
						oak = new Oak();
					} else if (qName.equalsIgnoreCase("ID"))
					{
						isTreeId = true;
					} else if (qName.equalsIgnoreCase("HEIGHT") && !isLeafBegin)
					{
						isTreeHeight = true;
					} else if (qName.equalsIgnoreCase("WIDTH") && !isLeafBegin)
					{
						isTreeWidth = true;
					} else if (qName.equalsIgnoreCase("AGE"))
					{
						isTreeAge = true;
					} else if (qName.equalsIgnoreCase("LEAFCOUNT"))
					{
						isLeafCount = true;
					} else if (qName.equalsIgnoreCase("LEAF") && !isLeafBegin)
					{
						isLeafBegin = true;
					} else if (qName.equalsIgnoreCase("Color"))
					{
						isLeafColor = true;
					} else if (qName.equalsIgnoreCase("HEIGHT") && isLeafBegin)
					{
						isLeafHeight = true;
					} else if (qName.equalsIgnoreCase("WIDTH") && isLeafBegin)
					{
						isLeafWidth = true;
					}

				}

				@Override
				public void characters(char ch[], int start, int length)
						throws SAXException
				{

					if (isTreeId)
					{
						System.out.println("ID : "
								+ new String(ch, start, length));

						oak.setId(Integer
								.valueOf((new String(ch, start, length))));

						isTreeId = false;
					} else if (isTreeHeight)
					{
						System.out.println("TreeHeight : "
								+ new String(ch, start, length));

						oak.setHeight(Integer.valueOf((new String(ch, start,
								length))));
						isTreeHeight = false;
					} else if (isTreeWidth)
					{
						System.out.println("TreeWidth : "
								+ new String(ch, start, length));

						oak.setWidth(Integer.valueOf((new String(ch, start,
								length))));

						isTreeWidth = false;
					} else if (isTreeAge)
					{
						System.out.println("TreeAge : "
								+ new String(ch, start, length));

						oak.setAge(Integer.valueOf((new String(ch, start,
								length))));

						isTreeAge = false;
					} else if (isLeafCount)
					{
						System.out.println("LeafCount : "
								+ new String(ch, start, length));

						LeafCount = Integer.valueOf((new String(ch, start,
								length)));

						isLeafCount = false;
					} else if (isLeafColor)
					{
						System.out.println("LeafColor :"
								+ new String(ch, start, length));

						leafColor = new String(ch, start, length);
						oakLeaf.setColor(leafColor);

						isLeafColor = false;
					} else if (isLeafHeight)
					{
						System.out.println("LeafHeight : "
								+ new String(ch, start, length));

						leafHeight = Integer.valueOf((new String(ch, start,
								length)));
						oakLeaf.setHeight(leafHeight);

						isLeafHeight = false;
					} else if (isLeafWidth)
					{
						List<Leaf> tempLeafList = new ArrayList();

						System.out.println("LeafWidth : "
								+ new String(ch, start, length));

						leafWidth = Integer.valueOf((new String(ch, start,
								length)));
						oakLeaf.setWidth(leafWidth);

						for (int i = oak.getId() + 1; i < LeafCount
								+ oak.getId() + 1; i++)
						{
							oakLeaf.setId(i);
							LeafList.add(oakLeaf);
							oakLeaf = new OakLeaf(leafColor, leafHeight,
									leafWidth);
						}

						tempLeafList.addAll(LeafList);
						oak.setLeafList(tempLeafList);
						TreeList.add(oak);
						oak = new Oak();
						oakLeaf = new OakLeaf();
						LeafList.clear();

						isLeafWidth = false;
						isTreeBegin = false;
						isLeafBegin = false;
						isLeafHeight = false;
					}

				}
			};

			saxParser
					.parse("d:\\Java Projects\\Git\\ForestVY\\ForestVY\\assets\\file+.xml",
							handler);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
