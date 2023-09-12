package RestassuredUtils;


import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestassuredUtils {
	
	public static Response performPost(String endPoint, String requestPayload) {
		
		 return RestAssured.given().log().all()
		.baseUri(endPoint)
		.contentType(ContentType.JSON)
		.body(requestPayload)
		.post()
		.then().log().all().extract().response();
		
	}

	public static Response performPost(String endPoint, Map<String, Object> requestPayload) {
		// TODO Auto-generated method stub
		return RestAssured.given().log().all()
				.baseUri(endPoint)
				.contentType(ContentType.JSON)
				.body(requestPayload)
				.post()
				.then().log().all().extract().response();
	}
	
}
