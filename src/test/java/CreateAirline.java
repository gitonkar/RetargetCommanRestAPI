import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAirline {
	@Test
	public void createAirline() {
		// TODO Auto-generated method stub
		Response resposne = RestAssured.given().log().all().baseUri("https://api.instantwebtools.net/v1/airlines").contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"id\": 1234535,\r\n"
						+ "    \"name\": \"Sri Lankan Airways\",\r\n"
						+ "    \"country\": \"Sri Lanka\",\r\n"
						+ "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\r\n"
						+ "    \"slogan\": \"From Sri Lanka\",\r\n"
						+ "    \"head_quaters\": \"Katunayake, Sri Lanka\",\r\n"
						+ "    \"website\": \"www.srilankaairways.com\",\r\n"
						+ "    \"established\": \"1990\"\r\n"
						+ "}").post().then().log().all().extract().response();
		Assert.assertEquals(resposne.statusCode(), 200);
	}
}
