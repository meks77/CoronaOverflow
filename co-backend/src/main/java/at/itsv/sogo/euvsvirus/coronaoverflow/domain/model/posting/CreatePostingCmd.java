package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Id;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.LabelId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public class CreatePostingCmd {

    private final PostingId id;
    private final Title title;
    private final LabelId labelId;
    private final Timestamp created;
    private final PostingText text;
    private final UserId userId;

    public CreatePostingCmd(UserId userId, Title title, LabelId labelId, PostingText text) {
        Objects.requireNonNull(text, "text");
        Objects.requireNonNull(labelId, "labelId");
        Objects.requireNonNull(title, "title");
        Objects.requireNonNull(userId, "userId");
        id = new PostingId(UUID.randomUUID().toString());
        created = new Timestamp(ZonedDateTime.now());
        this.userId = userId;
        this.title = title;
        this.labelId = labelId;
        this.text = text;
    }

    public PostingId getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public LabelId getLabelId() {
        return labelId;
    }

    public Timestamp getCreated() {
        return created;
    }

    public PostingText getText() {
        return text;
    }

    public UserId getUserId() {
        return userId;
    }
}
