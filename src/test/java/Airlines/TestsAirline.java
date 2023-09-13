package Airlines;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import RestassuredUtils.RestassuredUtils;
import Utils.JsonUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
@Listeners(ExtentReportManager.Setup.class)
public class TestsAirline extends AirlineAPIs {
	@Test
	public void createAirline() {
	
		Map<String, Object> requestPayload = Payloadss.createAirlinePayloadWithHashMAP("3654672", "Sri Lankan Airways", "Sri Lanka",
				"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
				"From Sri Lanka", "Katunayake, Sri Lanka", "www.srilankaairways.com", "1990");	
		Response resposne = createAirline(requestPayload);
		Assert.assertEquals(resposne.statusCode(), 200);
		
	}
}
