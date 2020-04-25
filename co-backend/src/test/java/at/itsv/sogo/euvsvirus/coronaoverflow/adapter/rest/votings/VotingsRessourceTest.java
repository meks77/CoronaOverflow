package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.votings;

import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class VotingsRessourceTest {

    @Inject
    AgroalDataSource dataSource;

    @Test
    void givenNoUserVoteWhenVoteUp() throws SQLException {
        String postUuid = "postingUUID1";
        String userId = "user3";
        given().header("X-CO-USERID", userId)
                .when().put("/voting/" + postUuid + "/voteUp")
                .then()
                .statusCode(SC_OK);
        assertVotingInDB(postUuid, userId, "UP");
    }

    private void assertVotingInDB(String postUuid, String userId, String expectedVotingValue) throws SQLException {
        try (PreparedStatement statement = dataSource.getConnection()
                .prepareStatement("select v.voted FROM VOTINGS v where v.post_id = ? and v.user_id = ?")) {
            statement.setString(1, postUuid);
            statement.setString(2, userId);
            ResultSet resultSet = statement.executeQuery();
            assertTrue(resultSet.next(), "no voting found");
            assertEquals(expectedVotingValue, resultSet.getString(1));
            assertFalse(resultSet.next(), "too many votings found");
        }
    }

    @Test
    void givenNoUserVoteWhenVoteDown() throws SQLException {
        String userId = "user3";
        String postUuid = "postingUUID2";
        given().header("X-CO-USERID", userId)
                .when().put("/voting/" + postUuid + "/voteDown")
                .then()
                .statusCode(SC_OK);
        assertVotingInDB(postUuid, userId, "DOWN");
    }

    @Test
    void givenUserDownVoteWhenVoteUp() throws SQLException {
        String postUuid = "postingUUID1";
        String userId = "user2";

        given().header("X-CO-USERID", userId)
                .when().put("/voting/" + postUuid + "/voteUp")
                .then()
                .statusCode(SC_OK);
        assertVotingInDB(postUuid, userId, "UP");
    }

    @Test
    void givenUserUpVoteWhenVoteDown() throws SQLException {
        String postUuid = "postingUUID4";
        String userId = "user1";

        given().header("X-CO-USERID", userId)
                .when().put("/voting/" + postUuid + "/voteDown")
                .then()
                .statusCode(SC_OK);
        assertVotingInDB(postUuid, userId, "DOWN");
    }

}