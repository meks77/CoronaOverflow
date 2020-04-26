package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.LabelId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

public class CreatePostingCmd {

    private final PostingProperties postingProperties;

    public CreatePostingCmd(UserId userId, Title title, LabelId labelId, PostingText text) {
        this.postingProperties = new PostingProperties(new PostingId(UUID.randomUUID().toString()),
                new Timestamp(ZonedDateTime.now()), userId, title, labelId, text, null);
    }

    public PostingProperties getPostingProperties() {
        return postingProperties;
    }
}
