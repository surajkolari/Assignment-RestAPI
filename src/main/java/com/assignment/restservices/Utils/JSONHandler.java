package com.assignment.restservices.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
public class JSONHandler {
	public List<Map<String, String>> loadJSONData() throws FileNotFoundException, IOException, ParseException  
    { 
        // parsing file "JSONExample.json" 
		String fileName = "cars-db.json";
		String dbText = "";
//        ClassLoader classLoader = new JSONHandler().getClass().getClassLoader();
//        File file = new File(classLoader.getResource(fileName).getFile());
//        Object obj = new JSONParser().parse(new String(Files.readAllBytes(file.toPath()))); 
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		org.springframework.core.io.Resource resource = resolver.getResource("classpath:cars-db.json");
//		File file = new File(resources.getFile(),"");
//		Object obj = new JSONParser().parse(new String(Files.readAllBytes(file.toPath())));
		InputStream dbAsStream = resource.getInputStream();
	    StringBuilder textBuilder = new StringBuilder();
	    try (Reader reader = new BufferedReader(new InputStreamReader
	      (dbAsStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
	        int c = 0;
	        while ((c = reader.read()) != -1) {
	            textBuilder.append((char) c);
	        }
	    }
		Object obj = new JSONParser().parse(textBuilder.toString());

        return (List<Map<String, String>>)obj;    
		
		
    }

}
