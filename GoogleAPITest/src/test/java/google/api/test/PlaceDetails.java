package google.api.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;

public class PlaceDetails extends APIObjects {
	
	@Test 
	public void getRequestValidParams(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeDetailsURL + "placeid=" + validPlaceID + "&key=" + validAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("OK"))
        .body("result.name", equalTo("Daft Media Ltd"));
	}
	
	@Test
	public void getRequestInvalidParams(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeDetailsURL + "placeid=" + invalidPlaceID + "&key=" + invalidAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("REQUEST_DENIED"))
        .body("error_message", equalTo("The provided API key is invalid."));
	}
	
	@Test
	public void getRequestInvalidPlaceID(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeDetailsURL + "placeid=" + invalidPlaceID + "&key=" + validAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("INVALID_REQUEST"));
		
	}
	
	@Test
	public void getRequestInvalidAPIKey(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeDetailsURL + "placeid=" + validPlaceID + "&key=" + invalidAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("REQUEST_DENIED"))
        .body("error_message", equalTo("The provided API key is invalid."));
	}
	
	@Test
	public void getRequestEmptyAPIKey(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeDetailsURL + "placeid=" + validPlaceID + "&key=")
    .then()
        .statusCode(200)
        .body("status", equalTo("REQUEST_DENIED"))
        .body("error_message", equalTo("This service requires an API key."));
        
	}
	
	@Test
	public void getRequestEmptyPlaceID(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeDetailsURL + "placeid=&key=" + validAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("INVALID_REQUEST"));
		
	}
	
	@Test
	public void getRequestMissingPlaceID(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeDetailsURL + "key=" + validAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("INVALID_REQUEST"));
		
	}
	
	@Test
	public void getRequestMissingAPIKey(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeDetailsURL + "placeid=" + validPlaceID)
    .then()
        .statusCode(200)
        .body("status", equalTo("REQUEST_DENIED"))
        .body("error_message",equalTo("This service requires an API key."));
		
	}
	
	@Test
	public void getRequestDifferentPlaceID(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeDetailsURL + "placeid=" + differentValidPlaceID + "&key=" + validAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("OK"))
        .body("result.name", equalTo("ODTÜ Kampüsü"));
		
	}
	
		
	}
	
	


