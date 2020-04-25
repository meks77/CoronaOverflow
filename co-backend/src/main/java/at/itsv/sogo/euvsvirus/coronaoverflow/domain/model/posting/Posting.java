package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;


import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.AggregateRoot;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Id;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.LabelId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

@AggregateRoot
public class Posting {

    private PostingId id;
    private UserId userId;
    private Title title;
    private LabelId labelId;
    private Timestamp created;
    private PostingText text;

    public Posting(CreatePostingCmd cmd) {
        id = cmd.getId();
        userId = cmd.getUserId();
        title = cmd.getTitle();
        labelId = cmd.getLabelId();
        created = cmd.getCreated();
        text = cmd.getText();
    }



    public Id id() {
        return id;
    }

    public Title title() {
        return title;
    }

    public Id labelId() {
        return labelId;
    }

    public Timestamp created() {
        return created;
    }

    public PostingText text() {
        return text;
    }

    public Id userId() {
        return userId;
    }
}
