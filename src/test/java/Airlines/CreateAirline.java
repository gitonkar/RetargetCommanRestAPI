package Airlines;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import RestassuredUtils.RestassuredUtils;
import Utils.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAirline {
	@Test
	public void createAirline() {
		// TODO Auto-generated method stub
		System.out.println("Environment value = "+System.getProperty("env"));
		String env = System.getProperty("env")==null?"qa":System.getProperty("env");
		//mvn test -Denv=qa 
		
		Map<String, String> data = JsonUtils.getJsonDataAsMap("/Airlines/"+env+"/airlinesApiData.json");
		String endPoint = data.get("createAirlineEndpoint");
		
		Map<String, Object> requestPayload = Payloadss.createAirlinePayloadWithHashMAP("3654661", "Sri Lankan Airways", "Sri Lanka",
				"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
				"From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990");
		
		Response resposne = RestassuredUtils.performPost(endPoint, requestPayload);
		Assert.assertEquals(resposne.statusCode(), 200);
		
	}
}
