package google.api.test;


public class APIObjects {
	
	public String validAPIKey = "AIzaSyDL8LEcWxDowTzoquEi58RKTBRAGSIKtD0";
	public String validPlaceID = "ChIJP21xjzoMZ0gRCx5wtxaPWPI";
	public String invalidAPIKey = "AIzaSyDL8LEcWxDowTzoquEi58";
	public String invalidPlaceID = "ChIJxjzoMZ0gRCx5wtxaPWPI";
	public String differentValidPlaceID = "ChIJeYkMpDtG0xQRFvGU8HDiOt4";
	
	// For Place Detail Test Cases
	public String placeDetailsURL = "https://maps.googleapis.com/maps/api/place/details/json?";
	
	
	// For Place Search Test Cases
	public String placeSearchURL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";
	public double latitude = 39.898578;
	public double longitude = 32.776217;
	public String enLang = "en";
	public String trLang = "tr";
	public int validRadius = 5000;
	public int invalidRadius = 50001;
	public String type = "restaurant";
	
	//For Place Add/Delete Test Cases
	public String placeAddURL = "https://maps.googleapis.com/maps/api/place/add/xml?";
	public String placeDeleteURL = "https://maps.googleapis.com/maps/api/place/delete/xml?";
	public String validPOSTRequestBodyAdd = 
			"<PlaceAddRequest>  "
			+ "<location>    <lat>-33.8669710</lat>    <lng>151.1958750</lng>  </location>  "
			+ "<accuracy>50</accuracy>  "
			+ "<name>Google Shoes!</name>  "
			+ "<phone_number>(02) 9374 4000</phone_number>  "
			+ "<address>48 Pirrama Road, Pyrmont, NSW 2009, Australia</address>  "
			+ "<type>shoe_store</type>  "
			+ "<website>http://www.google.com.au/</website>  "
			+ "<language>en-AU</language></PlaceAddRequest>";
	
	
	
	
	
	

}
