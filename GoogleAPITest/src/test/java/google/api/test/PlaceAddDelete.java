package google.api.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class PlaceAddDelete extends APIObjects {
	
	public String place_id;
	
	@Test (priority=1,testName="successfulPOSTRequestAdd",description="Successful Place Add")
	public void successfulPOSTRequestAdd(){
		 Response responseAddPlace = 
				 given()
				 	.contentType(ContentType.JSON)
				 	.body(validPOSTRequestBodyAdd)
				 .expect()
				 	.statusCode(200)
				 	.body("status", equalTo("OK"))
				 .when()
				 	.post(placeAddURL + "key=" + validAPIKey)
    ;
		
		
	String responseAddPlaceText = responseAddPlace.getBody().asString();
	System.out.println(responseAddPlaceText);
	
	JsonPath jsonPath = new JsonPath(responseAddPlaceText);
	place_id = jsonPath.getString("place_id");	
	System.out.println(place_id);
		
	}
	
	@Test (priority=2,testName="successfulPOSTRequestDelete",description="Successful Place Delete")
	public void successfulPOSTRequestDelete(){
		
		Response responseDeletePlace = 
				given()
					.contentType(ContentType.JSON)
					.body(validPOSTDeleteBodyAdd_01+place_id+validPOSTDeleteBodyAdd_02)
				.expect()
					.statusCode(200)
					.body("status", equalTo("OK"))
				.when()
					.post(placeDeleteURL + "key=" + validAPIKey);
		
      System.out.println(responseDeletePlace.getBody().asString());

	}
	
	@Test (priority=3,testName="alreadyDeletedPOSTRequestDelete",description="status message for already deleted place in response body",dependsOnMethods = {"successfulPOSTRequestDelete"} )
	public void alreadyDeletedPOSTRequestDelete(){
		
		Response alreadyDeletedPlace =
				given()
					.contentType(ContentType.JSON)
					.body(validPOSTDeleteBodyAdd_01+place_id+validPOSTDeleteBodyAdd_02)
				.expect()
					.statusCode(200)
					.body("status", equalTo("NOT_FOUND"))
					.when()
				.post(placeDeleteURL + "key=" + validAPIKey);
		
		System.out.println(alreadyDeletedPlace.getBody().asString());

	}

}
