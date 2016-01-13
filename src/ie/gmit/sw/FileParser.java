package ie.gmit.sw;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser {
	
	//put into its own class
	public  Map<String, Double> parse(String file) throws IOException {
		 Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String next = null;
		
		while((next = br.readLine())!= null){
				// ADD EACH LINE TO THE PARSE
				String [] stuff = next.split(" ");
				//map.put(stuff[0]),stuff[1]);
				String string1 = stuff[0];
				double num1 = (double) Long.parseLong(stuff[1]);
				temp.put(string1, num1);
		}
		return temp;
		
		
	}
}
