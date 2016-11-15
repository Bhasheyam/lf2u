package Service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import DataGeneration.Farmerdata;
import dataList.*;
import DataGeneration.Farmerdata;

public class Farmservice {
	
	
	public String Addaccount(StringBuilder s) throws JsonParseException, JsonMappingException, IOException
	{
		Farmerdata fm=new Farmerdata();
		ObjectMapper mapper = new ObjectMapper();
		fm=mapper.readValue(s.toString(),Farmerdata.class);
	
		return fm.getfid();
	}

}
