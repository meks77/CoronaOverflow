package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Link;
import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Method;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Votings;
import org.jsoup.Connection;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostingTranslator {

    PostingDto translate(Posting posting, Votings votings, Optional<UserId> userId) {
        return PostingDto.PostingDtoBuilder.aPostingDto()
                .withPostingID(posting.id().val())
                .withUserID(posting.userId().val())
                .withTitle(posting.title().text())
                .withText(posting.text().text())
                .withDate(ZonedDateTime.ofInstant(posting.created().timestamp().toInstant(), ZoneId.of("UTC"))
                        .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "Z")
                .withVotes(new VotesDto(votings.amountUp(),
                                        votings.amountDown(),
                                        userId.flatMap( votings::voteForUser ).map(vote -> vote.isUp() ? "up" : "down").orElse(null),
                                        linksToVoteFor( posting.id()),
                                        votings.rating()))
                .withImage(new Image("testpicture.jpg", "image/jpeg",  getFileContent("/dummyPicture.txt")))
                .build();
    }

    private String getFileContent(String fileName) {
        InputStream inputStream = getClass().getResourceAsStream(fileName);
        byte[] buffer = new byte[8192];
        StringBuilder imageContentBuilder = new StringBuilder();
        try {
            inputStream.read(buffer);
            imageContentBuilder.append(new String(buffer));
            return imageContentBuilder.toString();
        } catch (IOException e) {
            throw new IllegalStateException("error while reading dummy picture", e);
        }
    }

    private List<Link> linksToVoteFor(PostingId id) {
        return Arrays.asList(
                new Link("voteUp", "voting/" + id.val() + "/voteUp", Method.PUT ),
                new Link("voteDown", "voting/" + id.val() + "/voteDown", Method.PUT )
        );
    }
}
