package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;


import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.AggregateRoot;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Timestamp;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Title;

@AggregateRoot
public class Posting {

    private Id id;
    private Id userId;
    private Title title;
    private Id labelId;
    private Timestamp created;
    private PostingText text;
    private Votes votes;

    public Posting(CreatePostingCmd cmd) {
        id = cmd.getId();
        userId = cmd.getUserId();
        title = cmd.getTitle();
        labelId = cmd.getLabelId();
        created = cmd.getCreated();
        text = cmd.getText();
        votes = new Votes();
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

    public Votes votes() {
        return votes;
    }

    public Id userId() {
        return userId;
    }
}
