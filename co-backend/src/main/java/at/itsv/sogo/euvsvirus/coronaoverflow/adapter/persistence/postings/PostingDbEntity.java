package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.labels.LabelDbEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "POSTS")
public class PostingDbEntity extends PanacheEntity {

    public String uuid;

    @Column(name = "user_id")
    public String userId;

    public String title;

    @ManyToOne
    @JoinColumn(name = "LABEL_ID")
    public LabelDbEntity label;

    public ZonedDateTime created;

    public String text;

    static List<PostingDbEntity> findByLabel(LabelDbEntity label) {
        return list("label", label);
    }

}
