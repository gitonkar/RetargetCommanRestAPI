package Utils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static Map<String, String> getJsonDataAsMap(String fileName){
		
		String completeJsonFilePath = System.getProperty("user.dir")+"/src/test/resources" 
		+fileName;
		
		Map<String, String> data = null;
		
		try {
			data = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	
	}

}
