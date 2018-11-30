import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

public class WeaveSocksRestAssuredTest {


    @Test
    public void makeSureThatJasonPlaceHolderIsUp() {
        given().when().get("http://localhost:4180").then().statusCode(200);

    }

    @Test
    public void checkingCatalogueSizeResponse() {

        RestAssured.registerParser("text/plain",Parser.JSON);
                given().
                when().
                get("http://localhost:4180/catalogue/size").
                then().
                statusCode(200).log().all().
                body("size",equalTo(9));
    }

    @Test
    public void testingProductResponseById() {
        RestAssured.registerParser("text/plain",Parser.JSON);
        given().
                when().
                get("http://localhost:4180/catalogue/03fef6ac-1896-4ce8-bd69-b798f85c6e0b").
                then().
                assertThat().
                statusCode(200).log().all().
                body("name",equalTo("Holy"));

    }
    @Test
    public void testingTags() {
        RestAssured.registerParser("text/plain",Parser.JSON);
        String[] tagi= {"brown","geek","formal","blue","skin","red","action","sport","black","magic","green"};
                given().
                when().
                get("http://localhost:4180/tags").
                then().
                assertThat().
                statusCode(200).log().all().
                body("tags.size()",equalTo(11));
//                body("tags".contentEquals(tagi);
    }

    @Test
    public void testingLogin() {
        RestAssured.registerParser("text/plain",Parser.JSON);
    given()
                .contentType("application/json")
                .auth()
                .preemptive()
                .basic("test", "test")
                .when()
                    .post("http://localhost:4180")
                .then()
                    .log()
                    .all();
//                    .time(lessThan(5000L));
//            .body("returnUrl", equalTo("/browse/" + project.get("key")));
}








    }


