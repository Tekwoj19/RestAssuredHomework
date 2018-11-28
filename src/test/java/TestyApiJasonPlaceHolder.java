import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
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
                body("findAll{ it.website.endsWith(\".org\")}.size()", equalTo(2));

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
                body(("address.zipcode[5]".equals("23505-1337")));

    }

    @Test
    public void contentEncodingTest() {

        ValidatableResponse response = given().contentType("gzip").when().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);
        String contentType = response.extract().header("Content-Encoding");
        Assert.assertEquals(contentType, "gzip");


    }


    @Test
    public void userShouldBeAbleToBrowsePosts() {

        given().
                when().
                get("https://jsonplaceholder.typicode.com/posts/1").
                then().
                statusCode(200).
                body("id", equalTo(1));

    }


    @Test
    public void userShouldBeAbleToBrowseCommentsForSpecificPost() {

        given().
                when().
                get("https://jsonplaceholder.typicode.com/posts/1/comments").
                then().
                statusCode(200).
                body("postId", hasSize(5)).
                and().
                contentType(ContentType.JSON);


    }


}




