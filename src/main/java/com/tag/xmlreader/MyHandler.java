package com.tag.xmlreader;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.tag.entity.Product;

public class MyHandler extends DefaultHandler {
	private List<Product> productList = new ArrayList<Product> ();
	private Product product = null;
	private StringBuilder data = null;

	public List<Product> getProductList() {
		return productList;
	}

	boolean bId = false;
	boolean bCode = false;
	boolean bName = false;
	boolean bDescription = false;
	boolean bThumbnailUrl = false;
	boolean bWebsiteUrl = false;
	boolean bCurrency = false;
	boolean bPrice = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("product")) {
         product = new Product();
		} else if (qName.equalsIgnoreCase("tag_product_id")) {
			bId = true;
		} else if (qName.equalsIgnoreCase("product_name")) {
			bName = true;
		} else if (qName.equalsIgnoreCase("product_code")) {
			bCode = true;
		} else if (qName.equalsIgnoreCase("description")) {
			bDescription = true;
		} else if (qName.equalsIgnoreCase("picture_thumbnail_url")) {
			bThumbnailUrl = true;
		} else if (qName.equalsIgnoreCase("landing_url")) {
			bWebsiteUrl = true;
		} else if (qName.equalsIgnoreCase("currency")) {
			bCurrency = true;
		} else if (qName.equalsIgnoreCase("price")) {
			bPrice = true;
		}

		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(data);
		if (bId) {
			product.setId(Long.parseLong(data.toString()));
			bId = false;
		} else if (bName) {
			product.setName(data.toString());
			bName = false;
		} else if (bCode) {
			product.setCode(data.toString());
			bCode = false;
		} else if (bDescription) {
			product.setDescription(data.toString());
			bDescription = false;
		} else if (bCurrency) {
			product.setCurrency(data.toString());
			bCurrency = false;
		} else if (bWebsiteUrl) {
			product.setWebsiteUrl(data.toString());
			bWebsiteUrl = false;
		} else if (bThumbnailUrl) {
			product.setThumbnailUrl(data.toString());
			bThumbnailUrl = false;
		} else if (bPrice) {
			product.setPrice(Double.parseDouble(data.toString()));
			bPrice = false;
		}

		if (qName.equalsIgnoreCase("Product")) {
			
			productList.add(product);
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}
}
