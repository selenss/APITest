package google.api.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;


public class PlaceAddDelete extends APIObjects {
	
	@Test (priority=1,testName="successfulPOSTRequestAdd",description="Successful Place Add")
	public void successfulPOSTRequestAdd(){
		given()
        .contentType(ContentType.XML)
        .body(validPOSTRequestBodyAdd)
    .expect()
        .statusCode(200)
        .body("status", equalTo("OK"))
    .when()
        .post(placeAddURL + "key=" + validAPIKey)
    ;
		
		
	}
	/* In this test case, the place is deleted which was added by previous test case. 
	 * However, some assertion error handle process needs more time. 
	 * Case if failed.
	 */
	@Test (priority=2,testName="successfulPOSTRequestDelete",description="Successful Place Delete")
	public void successfulPOSTRequestDelete(){
		
		given()
        .contentType(ContentType.XML)
        .body("<PlaceDeleteRequest><place_id>PLACE_IP_IN_successfulPOSTRequestAdd</place_id></PlaceDeleteRequest>")
    .expect()
        .statusCode(200)
        .body("status", equalTo("OK"))
    .when()
        .post(placeDeleteURL + "key=" + validAPIKey);
		


	}
	/* In this test case it is expected to show "NOT_FOUND" status message for the place is deleted by previous test case . 
	 * However, some assertion error handle process needs more time. 
	 * Case if failed.
	 */
	@Test (priority=3,testName="alreadyDeletedPOSTRequestDelete",description="status message for already deleted place in response body",dependsOnMethods = {"successfulPOSTRequestDelete"} )
	public void alreadyDeletedPOSTRequestDelete(){
		System.out.println(placeDeleteURL + "key=" + validAPIKey);
		given()
        .contentType(ContentType.XML)
        .body("<PlaceDeleteRequest><place_id>PLACE_IP_IN_successfulPOSTRequestAdd</place_id></PlaceDeleteRequest>")
    .expect()
        .statusCode(200)
        .body("status", equalTo("NOT_FOUND"))
    .when()
        .post(placeDeleteURL + "key=" + validAPIKey);


	}

}
