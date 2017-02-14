package google.api.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;


public class PlaceSearch extends APIObjects {
	
	@Test
	public void getRequestLanguageEnglish(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeSearchURL + 
        	"location=" + latitude + "," +longitude + 
        	"&radius=" + validRadius + 
        	"&type=" + type + 
        	"&language=" + enLang +
        	"&key=" + validAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("OK"))
        .body(containsString("Cadir Kebap"));
		
	}
	
	@Test
	public void getRequestLanguageTurkish(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeSearchURL + 
        	"location=" + latitude + "," +longitude + 
        	"&radius=" + validRadius + 
        	"&type=" + type + 
        	"&language=" + trLang +
        	"&key=" + validAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("OK"))
        .body(containsString("Çadýr Kebap"));
	}
	
	@Test
	public void getRequestRadiusGreaterThan5000(){
		given()
        .contentType(ContentType.JSON)
        
    .when()
        .get(placeSearchURL + 
        	"location=" + latitude + "," +longitude + 
        	"&radius=" + invalidRadius + 
        	"&type=" + type + 
        	"&language=" + trLang +
        	"&key=" + validAPIKey)
    .then()
        .statusCode(200)
        .body("status", equalTo("INVALID_REQUEST"))
        .body("error_message", equalTo("The maximum allowed radius is 50000 meters."));
	}

}
