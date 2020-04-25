package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Timestamp;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Title;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public class CreatePostingCmd {

    private final Id id;
    private final Title title;
    private final Id labelId;
    private final Timestamp created;
    private final PostingText text;
    private final Id userId;

    public CreatePostingCmd(Id userId, Title title, Id labelId, PostingText text) {
        Objects.requireNonNull(text, "text");
        Objects.requireNonNull(labelId, "labelId");
        Objects.requireNonNull(title, "title");
        Objects.requireNonNull(userId, "userId");
        id = new Id(UUID.randomUUID().toString());
        created = new Timestamp(ZonedDateTime.now());
        this.userId = userId;
        this.title = title;
        this.labelId = labelId;
        this.text = text;
    }

    public Id getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public Id getLabelId() {
        return labelId;
    }

    public Timestamp getCreated() {
        return created;
    }

    public PostingText getText() {
        return text;
    }

    public Id getUserId() {
        return userId;
    }
}
