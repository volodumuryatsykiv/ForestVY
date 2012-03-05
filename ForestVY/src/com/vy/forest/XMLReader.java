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

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException
				{
					if (qName.equalsIgnoreCase("TREE") && !isTreeBegin)
					{
						isTreeBegin = true;
						oak = new Oak();
					}

					if (qName.equalsIgnoreCase("ID"))
					{
						isTreeId = true;
					}

					if (qName.equalsIgnoreCase("HEIGHT") && !isLeafBegin)
					{
						isTreeHeight = true;
					}

					if (qName.equalsIgnoreCase("WIDTH") && !isLeafBegin)
					{
						isTreeWidth = true;
					}

					if (qName.equalsIgnoreCase("AGE"))
					{
						isTreeAge = true;
					}

					if (qName.equalsIgnoreCase("LEAFCOUNT"))
					{
						isLeafCount = true;
					}

					if (qName.equalsIgnoreCase("LEAF") && !isLeafBegin)
					{
						isLeafBegin = true;
					}

					if (qName.equalsIgnoreCase("Color"))
					{
						isLeafColor = true;
					}

					if (qName.equalsIgnoreCase("HEIGHT") && isLeafBegin)
					{
						isLeafHeight = true;
					}

					if (qName.equalsIgnoreCase("WIDTH") && isLeafBegin)
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
					}

					if (isTreeHeight)
					{
						System.out.println("TreeHeight : "
								+ new String(ch, start, length));

						oak.setHeight(Integer.valueOf((new String(ch, start,
								length))));
						isTreeHeight = false;
					}

					if (isTreeWidth)
					{
						System.out.println("TreeWidth : "
								+ new String(ch, start, length));

						oak.setWidth(Integer.valueOf((new String(ch, start,
								length))));

						isTreeWidth = false;
					}

					if (isTreeAge)
					{
						System.out.println("TreeAge : "
								+ new String(ch, start, length));

						oak.setAge(Integer.valueOf((new String(ch, start,
								length))));

						isTreeAge = false;
					}

					if (isLeafCount)
					{
						System.out.println("LeafCount : "
								+ new String(ch, start, length));

						LeafCount = Integer.valueOf((new String(ch, start,
								length)));

						isLeafCount = false;
					}

					if (isLeafColor)
					{
						System.out.println("LeafColor :"
								+ new String(ch, start, length));

						oakLeaf.setColor(new String(ch, start, length));

						isLeafColor = false;
					}

					if (isLeafHeight)
					{
						System.out.println("LeafHeight : "
								+ new String(ch, start, length));

						oakLeaf.setHeight(Integer.valueOf((new String(ch,
								start, length))));

						isLeafHeight = false;
					}

					if (isLeafWidth)
					{
						System.out.println("LeafWidth : "
								+ new String(ch, start, length));

						oakLeaf.setWidth(Integer.valueOf((new String(ch, start,
								length))));

						for (int i = oak.getId() + 1; i <= LeafCount; i++)
						{
							oakLeaf.setId(i);
							LeafList.add(oakLeaf);
						}

						oak.setLeafList(LeafList);
						TreeList.add(oak);
						oak = new Oak();
						oakLeaf = new OakLeaf();

						isLeafWidth = false;
						isTreeBegin = false;
						isLeafBegin = false;
						isLeafHeight = false;
					}

				}
			};

			saxParser.parse("d:\\file+.xml", handler);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
