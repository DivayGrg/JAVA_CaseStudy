package GetRequests;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class Restfulapidev {
	public static void main(String args[])
	{
		Response response=given().when().
				get("https://api.restful-api.dev/objects").then()
				.extract().response();
		//Status code
		System.out.println("Statue Code : "+ response.getStatusCode());
		System.out.println("Complete Response : ");

		System.out.println(response.asPrettyString());
		System.out.println("Response Body : ");
		
		System.out.println(response.getBody().asPrettyString());
		System.out.println("Status Line : "+ response.getStatusLine());
		System.out.println("Content Type : " + response.getContentType());
	    System.out.println("Response Time : " + response.getTime() + " ms");
		
	}

}
