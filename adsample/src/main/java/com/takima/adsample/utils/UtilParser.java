package com.takima.adsample.utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.takima.adsample.entity.AdSample;

public class UtilParser {

	
	private UtilParser() {
	}
	
	
	public static AdSample parseAdSample(String path) throws IOException {
		StringBuilder data = new StringBuilder();
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(path);
		Scanner reader = new Scanner(file);
		
		while (reader.hasNextLine()) {
			data.append(reader.nextLine());
	      }
		reader.close();
		return objectMapper.readValue(data.toString(), AdSample.class);		
	}


}
