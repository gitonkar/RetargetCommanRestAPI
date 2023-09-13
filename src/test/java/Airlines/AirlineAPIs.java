package Airlines;

import java.util.Map;

import RestassuredUtils.RestassuredUtils;
import io.restassured.response.Response;

public class AirlineAPIs extends Base {
	
	public Response createAirline(Map<String,Object> createAirlinePayload) {
		String endPoint = (String) Base.dataFromJsonFile.get("createAirlineEndpoint");
		return RestassuredUtils.performPost(endPoint, createAirlinePayload);	
	}
}
