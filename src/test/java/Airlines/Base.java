package Airlines;

import java.util.Map;

import Utils.JsonUtils;

public class Base {
	
	public static Map<String, Object> dataFromJsonFile;
	
	static {
		//System.out.println("Environment value = "+System.getProperty("env"));
		String env = System.getProperty("env")==null?"qa":System.getProperty("env");
		//mvn test -Denv=qa 
		dataFromJsonFile = JsonUtils.getJsonDataAsMap("/Airlines/"+env+"/airlinesApiData.json");
		
	}
	
	
}
