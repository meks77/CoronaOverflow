package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.labels.LabelDbEntity;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "POSTS")
public class PostingDbEntity extends PanacheEntityBase {

    @Id
    public String uuid;

    @Column(name = "user_id")
    public String userId;

    public String title;

    @Column(name = "IMAGE_NAME")
    public String imageName;

    @ManyToOne
    @JoinColumn(name = "LABEL_ID")
    public LabelDbEntity label;

    public ZonedDateTime created;

    public String text;

    static List<PostingDbEntity> findByLabel(LabelDbEntity label) {
        return list("label", label);
    }

    static Optional<PostingDbEntity> findByID(String uuid) { return find("uuid", uuid).singleResultOptional(); }

    static List<PostingDbEntity> findByUser(UserId userId) { return list("userId", userId.val() ); }

}
