package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.labels;

import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class LabelsRessourceIT {

    @Inject
    AgroalDataSource dataSource;

    @Test
    void testLabelsEndpoint() {
        given()
                .when().get("/labels")
                .then()
                .statusCode(SC_OK)
                .body("[0].label", equalTo("Label X"))
                .body("[1].label", equalTo("LabelY"))
                .body("[2].label", equalTo("LabelZ"))
                .body("[0].link.method", equalTo("GET"))
                .body("[1].link.method", equalTo("GET"))
                .body("[2].link.method", equalTo("GET"))
                .body("[0].link.url", equalTo("/postings/forLabel/Label%20X"))
                .body("[1].link.url", equalTo("/postings/forLabel/LabelY"))
                .body("[2].link.url", equalTo("/postings/forLabel/LabelZ"));
    }

    @Test
    void givenLabelExistsWhenCreateLabel() throws SQLException {
        final String expectedLabel = "LabelY";
        assertLabelExistsInDatabase(expectedLabel);

        given()
                .when().header("X-CO-LABEL", expectedLabel).post("/labels")
                .then()
                .statusCode(SC_OK);
        assertLabelExistsInDatabase(expectedLabel);
    }

    private void assertLabelExistsInDatabase(String expectedLabel) throws SQLException {
        assertResultSet(expectedLabel, resultSet -> {
            try {
                assertTrue(resultSet.next(), "label not found in database");
                assertFalse(resultSet.next(), "too many labels found");
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

    private void assertResultSet(String expectedLabel, Consumer<ResultSet> verifier) throws SQLException {
        try (final Connection connection = dataSource.getConnection();
             final PreparedStatement stmt = connection.prepareStatement("select ID from LABELS where name = ?")) {
            stmt.setString(1, expectedLabel);
            ResultSet resultSet = stmt.executeQuery();
            verifier.accept(resultSet);
        }
    }

    @Test
    void givenLabelNotExistingWhenCreateLabel() throws SQLException {
        final String expectedLabel = "LabelY2";
        assertLabelDoesNotExist(expectedLabel);

        given()
                .when().header("X-CO-LABEL", expectedLabel).post("/labels")
                .then()
                .statusCode(SC_OK);
        assertLabelExistsInDatabase(expectedLabel);
    }

    private void assertLabelDoesNotExist(String expectedLabel) throws SQLException {
        assertResultSet(expectedLabel, resultSet -> {
            try {
                assertFalse(resultSet.next(), "label found, but shouldn't");
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }

}