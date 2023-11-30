package com.tag.xmlreader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToCsv {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		String jsonString;
		JSONObject jsonObject;
		try {

			jsonString = new String(Files.readAllBytes(Paths.get("C:\\Feed\\Sample Feed\\Sample Feed\\File1.json")));
			jsonObject = new JSONObject(jsonString);
			JSONArray docs = jsonObject.getJSONArray("items");
			File file = new File("C:\\Feed\\Sample Feed\\Sample Feed\\New_file1.csv");
			String csvString = CDL.toString(docs);
			FileUtils.writeStringToFile(file, csvString);
			System.out.println("Done");
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
