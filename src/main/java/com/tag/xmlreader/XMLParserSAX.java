package com.tag.xmlreader;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.tag.entity.Product;

public class XMLParserSAX {

	public static void main(String[] args) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			MyHandler handler = new MyHandler();
			saxParser.parse(new File("C:\\Feed\\Sample Feed\\Sample Feed\\tag_product_feed.xml"), handler);
			List<Product> productList = handler.getProductList();
			for (Product product : productList) {
				System.out.println(product);
			}
//			String xml = saxParser.toXML(productList);
//			FileWriter writer = new FileWriter("C:\\\\Feed\\\\Sample Feed\\\\Sample Feed\\\\new_tag_product_feed.xml");
//			writer.write(xml);
//			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
