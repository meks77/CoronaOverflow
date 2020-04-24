package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.label;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
class LabelRessourceIT {

    @Test
    void testLabelsEndpoint() {
        given()
                .when().get("/labels")
                .then()
                .statusCode(200)
                .body("[0].label", equalTo("LabelX"))
                .body("[1].label", equalTo("LabelY"))
                .body("[2].label", equalTo("LabelZ"))
                .body("[0].link.method", equalTo("GET"))
                .body("[1].link.method", equalTo("GET"))
                .body("[2].link.method", equalTo("GET"))
                .body("[0].link.url", equalTo("/label/LabelX"))
                .body("[1].link.url", equalTo("/label/LabelY"))
                .body("[2].link.url", equalTo("/label/LabelZ"));
    }

}