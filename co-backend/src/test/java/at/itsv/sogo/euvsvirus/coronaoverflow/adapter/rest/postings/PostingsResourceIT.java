package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
class PostingsResourceIT {

    @Test
    void testLabelPostingsEndpoint() {
        String postingsUrl = given()
                .when().get("/labels")
                .then()
                .statusCode(200)
                .extract().body().path("[2].link.url");
        given()
                .when().get(postingsUrl)
                .then()
                .statusCode(SC_OK)
                .body("[0].postingID", equalTo("postingUUID6"))
                .body("[0].userID", equalTo("user1"))
                .body("[0].date", equalTo("2012-09-17T16:47:52Z"))
                .body("[0].title", equalTo("Posting 6 title"))
                .body("[0].text", equalTo("Posting text 6"))
                .body("[0].votes.up", equalTo(0))
                .body("[0].votes.down", equalTo(0))
                .body("[0].voted", equalTo(false));
    }

}