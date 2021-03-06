package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;


import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.AggregateRoot;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.LabelId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

import java.util.Objects;
import java.util.Optional;

@AggregateRoot
public class Posting {

    private PostingId id;
    private UserId userId;
    private Title title;
    private LabelId labelId;
    private Timestamp created;
    private PostingText text;
    private Image image;

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
        posting.image = props.getImage();
        return posting;
    }

    public static Posting createNew(CreatePostingCmd cmd) {
        Objects.requireNonNull(cmd, "cmd");
        return create(cmd.getPostingProperties());
    }

    private Posting() {

    }



    public PostingId id() {
        return id;
    }

    public Title title() {
        return title;
    }

    public LabelId labelId() {
        return labelId;
    }

    public Timestamp created() {
        return created;
    }

    public PostingText text() {
        return text;
    }

    public UserId userId() {
        return userId;
    }

    public Optional<Image> image() {
        return Optional.ofNullable(image);
    }
}
