package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.label;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
class LabelRessourceTest {

    @Test
    void testLabelsEndpoint() {
        given()
                .when().get("/labels")
                .then()
                .statusCode(200)
                .body("[0].label", equalTo("label1"))
                .body("[1].label", equalTo("label2"))
                .body("[2].label", equalTo("label3"))
                .body("[0].link.method", equalTo("GET"))
                .body("[1].link.method", equalTo("GET"))
                .body("[2].link.method", equalTo("GET"))
                .body("[0].link.url", equalTo("/label/label1"))
                .body("[1].link.url", equalTo("/label/label2"))
                .body("[2].link.url", equalTo("/label/label3"));
    }

}