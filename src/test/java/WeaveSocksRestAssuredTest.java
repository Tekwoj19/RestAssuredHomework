import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;

public class WeaveSocksRestAssuredTest {


    @Test
    public void makeSureThatJasonPlaceHolderIsUp() {
        given().when().get("http://localhost:4180").then().statusCode(200);

    }


    @Test
    public void checkingIfPostResponseReturn100Records() {

        given().
                contentType(" text/plain; charset=utf-8").
                when().
                get("http://localhost:4180/catalogue/size").
                then().
                contentType("text/plain; charset=utf-8").
                statusCode(200).
                body("size", hasSize(9));



    }

    @Test
    public void testingProductResponseById() {

//        String ori= "test";
//        String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6";

        given().
//                param("text",id).
                when().
                get("http://localhost:4180/catalogue/03fef6ac-1896-4ce8-bd69-b798f85c6e0b").
                then().
                assertThat().
                body("name",equalTo("Holy"));

    }

    }


