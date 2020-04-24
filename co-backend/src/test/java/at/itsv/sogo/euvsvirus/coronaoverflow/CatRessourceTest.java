package at.itsv.sogo.euvsvirus.coronaoverflow;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CatRessourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/cat")
          .then()
             .statusCode(200)
             .body(is("Cat says meow"));
    }

}