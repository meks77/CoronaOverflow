package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;

import javax.enterprise.context.ApplicationScoped;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class PostingTranslator {

    PostingDto translate(Posting posting) {
        return PostingDto.PostingDtoBuilder.aPostingDto()
                .withPostingID(posting.id().asText())
                .withUserID(posting.userId().asText())
                .withTitle(posting.title().text())
                .withText(posting.text().text())
                .withDate(ZonedDateTime.ofInstant(posting.created().timestamp().toInstant(), ZoneId.of("UTC"))
                        .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "Z")
                .withVoted(false)
                .withVotes(new VotesDto(posting.votes().upVotes(), posting.votes().downVotes()))
                .build();
    }
}
