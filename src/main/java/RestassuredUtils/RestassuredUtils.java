package RestassuredUtils;

import java.util.Map;

import ExtentReportManager.ExtentReportUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class RestassuredUtils {

	private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload) {
		return RestAssured.given().log().all().baseUri(endPoint).contentType(ContentType.JSON).body(requestPayload);

	}

	private static void printRequestLogInReport(RequestSpecification requestSpecification) {
		QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
		ExtentReportUtils.logInfoDetails("End Point is "+queryableRequestSpecification.getBaseUri());
		ExtentReportUtils.logInfoDetails("Method is "+queryableRequestSpecification.getMethod());
		//ExtentReportUtils.logInfoDetails("Headers are "+queryableRequestSpecification.getHeaders().asList().toString());
		ExtentReportUtils.logInfoDetails("Headers are ");
		ExtentReportUtils.logHeaders(queryableRequestSpecification.getHeaders().asList());
		ExtentReportUtils.logInfoDetails("Request Body is ");
		ExtentReportUtils.logJson(queryableRequestSpecification.getBody());
	}
	
	private static void printResponseLogInReport(Response response) {
		ExtentReportUtils.logInfoDetails("Response Status Code is "+response.getStatusCode());
		//ExtentReportUtils.logInfoDetails("Response Headers are "+response.getHeaders().asList().toString());
		ExtentReportUtils.logInfoDetails("Response Headers are ");
		ExtentReportUtils.logHeaders(response.getHeaders().asList());
		//ExtentReportUtils.logInfoDetails("Response Body is "+response.getBody().prettyPrint());
		ExtentReportUtils.logInfoDetails("Response Body is ");
		ExtentReportUtils.logJson(response.getBody().prettyPrint());
	}
	
	public static Response performPost(String endPoint, String requestPayload) {

		RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload);
		Response response = requestSpecification.post();
		printRequestLogInReport(requestSpecification);
		printResponseLogInReport(response);
		return response;
	}

	public static Response performPost(String endPoint, Map<String, Object> requestPayload) {
		// TODO Auto-generated method stub
		RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload);
		Response response = requestSpecification.post();
		printRequestLogInReport(requestSpecification);
		printResponseLogInReport(response);
		return response; 
	}

}
