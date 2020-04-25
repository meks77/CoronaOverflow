package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;


import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.AggregateRoot;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Id;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.LabelId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

import java.util.Objects;

@AggregateRoot
public class Posting {

    private PostingId id;
    private UserId userId;
    private Title title;
    private LabelId labelId;
    private Timestamp created;
    private PostingText text;

    public static Posting create(PostingProperties props) {
        Objects.requireNonNull(props, "props");
        Objects.requireNonNull(props.getPostingId(), "id");
        Objects.requireNonNull(props.getUserId(), "userId");
        Objects.requireNonNull(props.getLabelId(), "labelId");
        Objects.requireNonNull(props.getCreated(), "created");
        Objects.requireNonNull(props.getText(), "text");
        Posting posting = new Posting();

        posting.id = props.getPostingId();
        posting.userId = props.getUserId();
        posting.title = props.getTitle();
        posting.labelId = props.getLabelId();
        posting.created = props.getCreated();
        posting.text = props.getText();
        return posting;
    }

    private Posting() {

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
