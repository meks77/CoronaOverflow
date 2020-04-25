package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.labels;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
class LabelsRessourceIT {

    @Test
    void testLabelsEndpoint() {
        given()
                .when().get("/labels")
                .then()
                .statusCode(SC_OK)
                .body("[0].label", equalTo("LabelX"))
                .body("[1].label", equalTo("LabelY"))
                .body("[2].label", equalTo("LabelZ"))
                .body("[0].link.method", equalTo("GET"))
                .body("[1].link.method", equalTo("GET"))
                .body("[2].link.method", equalTo("GET"))
                .body("[0].link.url", equalTo("/postings/forLabel/LabelX"))
                .body("[1].link.url", equalTo("/postings/forLabel/LabelY"))
                .body("[2].link.url", equalTo("/postings/forLabel/LabelZ"));
    }

}