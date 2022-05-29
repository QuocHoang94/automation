package Common;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIClass {

    public String getToken;

    public String GenerateTokenAPI() {
        RestAssured.baseURI = "https://bookstore.demoqa.com";
        RequestSpecification request = RestAssured.given();

        String payload = "{\r\n" + " \"userName\": \"hainth\",\r\n" + " \"password\": \"123456Aa@\"\r\n" + "}";

        request.header("Content-Type", "application/json");
        Response responseToken = request.body(payload).post("/Account/v1/GenerateToken");
        String jsonString = responseToken.getBody().asString();
        getToken = jsonString;
        return JsonPath.from(jsonString).get("token");
    }


    public void DeleteBookAPI(String token) {
        String removeBookDetails = "{\r\n" + " \"isbn\": \"9781449325862\",\r\n" + " \"userId\": \"eb6aa660-0c8b-40a5-a4d5-14abe4288723\"\r\n" + "}";

        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token).header("Content-Type", "application/json");

        Response res = httpRequest.body(removeBookDetails).delete("/BookStore/v1/Book");
        System.out.println("The response code is - " + res.getStatusCode());
    }

    @Test
    public void AddBookAPI(String token){
        String addBookDetails = "{\n"
                + "  \"userId\": \"eb6aa660-0c8b-40a5-a4d5-14abe4288723\",\n"
                + "  \"collectionOfIsbns\": [\n"
                + "    {\n"
                + "      \"isbn\": \"9781449331818\"\n"
                + "    }\n"
                + "  ]\n"
                + "}";
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + token).header("Content-Type", "application/json");
        Response addBooksResponse = httpRequest.body(addBookDetails).post("/BookStore/v1/Books");

//        Assert.assertEquals(201, addBooksResponse.getStatusCode());
    }

    @Test
    public void TokenAuth() {
        RestAssured.baseURI = "https://bookstore.demoqa.com";
        RequestSpecification request = RestAssured.given();

        String payload = "{\r\n" + " \"userName\": \"hainth\",\r\n" + " \"password\": \"123456Aa@\"\r\n" + "}";

        request.header("Content-Type", "application/json");
        Response responseToken = request.body(payload).post("/Account/v1/GenerateToken");
        responseToken.prettyPrint();

//        DELETE BOOK

        String jsonString = responseToken.getBody().asString();

        String tokenGenerated = JsonPath.from(jsonString).get("token");

        String removeBookDetails = "{\r\n" + " \"isbn\": \"9781449325862\",\r\n" + " \"userId\": \"eb6aa660-0c8b-40a5-a4d5-14abe4288723\"\r\n" + "}";

        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Bearer " + tokenGenerated).header("Content-Type", "application/json");

        Response res = httpRequest.body(removeBookDetails).delete("/BookStore/v1/Book");
        System.out.println("The response code is - " + res.getStatusCode());
        Assert.assertEquals(res.getStatusCode(), 204);


//        Assert.assertEquals(204,response.getStatusCode());

//        Response responseDeleteBook = request.body(removeBookDetails).delete("/BookStore/v1/Book");
//        responseDeleteBook.prettyPrint();


//        ADD BOOK

//        String jsonString = responseToken.getBody().asString();
//
//        String tokenGenerated = JsonPath.from(jsonString).get("token");
//
//        request.header("Authorization", "Bearer " + tokenGenerated)
//                .header("Content-Type", "application/json");
//
//        String addBookDetails = "{\n"
//                + "  \"userId\": \"eb6aa660-0c8b-40a5-a4d5-14abe4288723\",\n"
//                + "  \"collectionOfIsbns\": [\n"
//                + "    {\n"
//                + "      \"isbn\": \"9781449325862\"\n"
//                + "    }\n"
//                + "  ]\n"
//                + "}";
//        Response addBooksResponse = request.body(addBookDetails).post("/BookStore/v1/Books");
//
//        Assert.assertEquals(201, addBooksResponse.getStatusCode());
//        addBooksResponse.prettyPrint();
    }
}
