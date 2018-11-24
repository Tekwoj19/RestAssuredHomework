import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.endsWithPath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class TestyApiJasonPlaceHolder {


    @Test
    public void makeSureThatJasonPlaceHolderIsUp() {
        given().when().get("https://jsonplaceholder.typicode.com").then().statusCode(200);

    }

    @Test
    public void checkingIfPostResponseReturn100Records() {

        given().
                when().
                get("https://jsonplaceholder.typicode.com/posts?100").
                then().
                contentType(ContentType.JSON).
                statusCode(200).
                body("id", hasSize(100));
    }

    @Test
    public void checkingNumberOfUsersThatEndsWith() {

        given().

                when().
                get("https://jsonplaceholder.typicode.com/users").then().contentType(ContentType.JSON).statusCode(200).
                body("{ website.endsWith(\".org\")}.size()", equalTo(9));
    }

    @Test
    public void checkingIfThereIsUserWithGivenZipCode() {

        given().
                when().
                get("https://jsonplaceholder.typicode.com/users").
                then().
                contentType(ContentType.JSON).
                statusCode(200).
                log().
                body(("zipcode".equals("23505-1337")));

    }

    @Test
    public void contentEncodingTest() {

        ValidatableResponse response = given().contentType("gzip").when().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);
        String contentType = response.extract().header("Content-Encoding");
        Assert.assertEquals(contentType, "gzip");


    }





}




