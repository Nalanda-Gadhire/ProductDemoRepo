package com.tag.xmlreader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.tag.entity.Product;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;

public class XStreamTranslator {

	public static void main(String[] args) {
		try {

			FileReader reader = new FileReader("C:\\Feed\\Sample Feed\\Sample Feed\\tag_product_feed.xml");
			//XStream xStream = new XStream();
			XStream xStream = new XStream(new DomDriver("UTF_8", new NoNameCoder()));
			xStream.addPermission(NoTypePermission.NONE);
			xStream.allowTypes(new Class[] { Product.class, List.class });

			xStream.alias("products", List.class);
			xStream.alias("product", Product.class);

			xStream.aliasField("tag_product_id", Product.class, "id");
			xStream.aliasField("product_name", Product.class, "name");
			xStream.aliasField("product_code", Product.class, "code");
			xStream.aliasField("description", Product.class, "description");
			xStream.aliasField("picture_thumbnail_url", Product.class, "thumbnailUrl");
			xStream.aliasField("landing_url", Product.class, "websiteUrl");
			xStream.aliasField("currency", Product.class, "currency");
			xStream.aliasField("price", Product.class, "price");
			xStream.aliasField("programId", Product.class, "programId");
			xStream.aliasField("programName", Product.class, "programName");

			List<Product> products = (List<Product>) xStream.fromXML(reader);
			for (Product product : products) {
				System.out.println(product);
			}
			String xml = xStream.toXML(products);
			FileWriter writer = new FileWriter("C:\\\\Feed\\\\Sample Feed\\\\Sample Feed\\\\new_tag_product_feed.xml");
			writer.write(xml);
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
