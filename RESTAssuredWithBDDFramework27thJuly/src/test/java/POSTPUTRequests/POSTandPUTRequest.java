package POSTPUTRequests;
import org.json.JSONObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class POSTandPUTRequest {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private JSONObject testUser;
    private int createdUserId;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        testUser = new JSONObject();
        testUser.put("name", "Test User");
        testUser.put("email", "raghu.astepahead@gmail.com");
        testUser.put("username", "raghavendra");
    }

    @Test(priority = 1)
    public void testPostRequestComplete() {
        System.out.println("\n\n=========== POST REQUEST - TRADITIONAL ===========");
        JSONObject user = new JSONObject(testUser.toString());
        user.put("id", 1);
        System.out.println("Request Body: " + user.toString(2));
        
        Response response = given()
                .header("Content-Type", "application/json")
                .body(user.toString())
                .post("/users");        
        printResponseDetails(response, "POST");
        org.testng.Assert.assertEquals(response.getStatusCode(), 201);
        
        JSONObject responseJson = new JSONObject(response.getBody().asString());
        if (responseJson.has("id")) { // Store created ID for PUT test
            createdUserId = responseJson.getInt("id");
            System.out.println("Created User ID: " + createdUserId);
        }
    }
    @Test(priority = 2)
    public void testBDDApproach() {
        System.out.println("\n\n========== BDD APPROACH ==========");
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "BDD Post");
        requestBody.put("body", "Testing BDD approach");
        requestBody.put("userId", 2);

        // BDD Style
        given().header("Content-Type", "application/json").body(requestBody.toString())
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .statusLine(containsString("201"))
            .contentType("application/json")
            .body("title", equalTo("BDD Post"))
            .body("userId", equalTo(2))
            .time(lessThan(5000L))
            .log().all();
    }

    @Test(priority = 3)
    public void testBDDApproachWithExtraction() {
        System.out.println("\n\n========== BDD APPROACH WITH EXTRACTION ==========");
        // Create JSON object
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "BDD with Extraction");
        requestBody.put("body", "Testing BDD with response extraction");
        requestBody.put("userId", 3);
        // BDD with extraction
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when().post("/posts")
                .then().statusCode(201).extract().response();
        // Print response details
        printResponseDetails(response, "BDD Extraction");    }
    // Helper method to print response details
    private void printResponseDetails(Response response, String approach) {
        System.out.println("\n--- " + approach + " Approach Response Details ---");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Content Type: " + response.getContentType());
        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Response Body: " + response.getBody().asString());
        System.out.println("Complete Response: " + response.asString());
    }

}
