package com.assignment.restservices.restservices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.restservices.Utils.JSONHandler;
import com.google.gson.Gson;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/rest-service/cars-db")
public class RestServices {
	List<Map<String, String>> data = new ArrayList<Map<String, String>>();
	
	//Static function to load JSON Data
	{
		try {
			data = (List<Map<String, String>>)new JSONHandler().loadJSONData();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data = null;
		}
	}
	
	//Return all cars
	@GetMapping("/cars")
	public String getAllCars() {
		return new Gson().toJson(data);
	}
	
	//Return size of dataset
	@GetMapping("/dataSize")
	public String dataSize() {
		HashMap<String,Integer> result=new HashMap<String, Integer>();
		result.put("Size", data.size());
		return new Gson().toJson(result);
	}
	
	//rReturn single car by id
	@GetMapping("/car/{id}")
	public String getCarByID(@PathVariable int id) {
		if(id > data.size()) {
			return new Gson().toJson("Max ID : " + data.size());
		}
		return new Gson().toJson(data.get(id));
	}

}
