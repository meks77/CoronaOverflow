package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.labels.LabelDbEntity;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class PostingsResourceIT {

    @Inject
    AgroalDataSource dataSource;

    @Test
    void testLabelPostingsEndpoint() {
        String postingsUrl = given()
                .when().get("/labels")
                .then()
                .statusCode(SC_OK)
                .extract().body().path("[2].link.url");
        given()
                .when().get(postingsUrl)
                .then()
                .statusCode(SC_OK)
                .body("[0].postingID", equalTo("postingUUID6"))
                .body("[0].userID", equalTo("Darin"))
                .body("[0].date", equalTo("2012-09-17T16:47:52Z"))
                .body("[0].title", equalTo("The best tools for distance learning"))
                .body("[0].text", equalTo("As a teacher I have come across many tools for home schooling and distance learning. This is a selection of free tools that I consider the most helpful."));
    }

    @Test
    void testCreateNewPosting() throws SQLException {
        StringWriter requestBodyWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(requestBodyWriter);
        final String expectedTitle = "new posting title";
        final String expectedText = "new posting text";
        final String labelName = "Masks";
        final Long expectedLabelId = LabelDbEntity.findByName(labelName).map(entity -> entity.id)
                        .orElseThrow(() -> new IllegalStateException("label for test not found"));

        JsonObject requestBody = Json.createObjectBuilder()
                .add("title", expectedTitle)
                .add("text", expectedText)
                .add("label", labelName).build();
        jsonWriter.writeObject(requestBody);
        String requestBodyJsonString = requestBodyWriter.toString();
        ZonedDateTime timeBeforeCreation = ZonedDateTime.now();
        String expectedUser = "user2";

        given()
                .header("X-CO-USERID", expectedUser)
                .contentType(ContentType.JSON)
                .body(requestBodyJsonString)
                .when().post("/postings")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);

        try (final Connection connection = dataSource.getConnection();
             final Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery("select * from POSTS order by created desc");
            assertTrue(resultSet.next(), "no posting found");
            assertAll(
                    () -> assertThat(

                                    resultSet.getTimestamp("created", Calendar.getInstance(TimeZone.getTimeZone("UTC")))
                                            )
                            .as("created")
                            .isAfterOrEqualTo(Date.from(timeBeforeCreation.toInstant())),
                    () -> assertThat(resultSet.getString("uuid")).as("uuid").isNotNull(),
                    () -> assertThat(resultSet.getString("user_id")).as("user_id").isEqualTo(expectedUser),
                    () -> assertThat(resultSet.getLong("label_id")).as("label_id").isEqualTo(expectedLabelId),
                    () -> assertThat(resultSet.getString("title")).as("title").isEqualTo(expectedTitle),
                    () -> assertThat(resultSet.getString("text")).as("text").isEqualTo(expectedText)
            );
        }

    }

}