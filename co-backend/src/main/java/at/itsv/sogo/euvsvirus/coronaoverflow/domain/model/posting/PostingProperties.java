package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.LabelId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

public class PostingProperties {

    private final PostingId postingId;
    private final Title title;
    private final LabelId labelId;
    private final Timestamp created;
    private final PostingText text;
    private final UserId userId;

    public PostingProperties(PostingId postingId, Timestamp created, UserId userId, Title title, LabelId labelId, PostingText text) {
        this.postingId = postingId;
        this.created = created;
        this.userId = userId;
        this.title = title;
        this.labelId = labelId;
        this.text = text;
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

    public PostingId getPostingId() {
        return postingId;
    }

}
