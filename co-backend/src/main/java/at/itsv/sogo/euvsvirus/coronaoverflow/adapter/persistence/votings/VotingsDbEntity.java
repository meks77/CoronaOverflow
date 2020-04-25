package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.votings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "VOTINGS")
public class VotingsDbEntity extends PanacheEntity {
    enum VOTE { UP, DOWN };
    @Column(name="USER_ID")
    String userId;

    @Column(name="POST_ID")
    String postingId;

    @Column(name="VOTED")
    @Enumerated(EnumType.STRING)
    VOTE voted;

    public UserId user() {
        return new UserId( userId );
    }

    public PostingId post() {
        return new PostingId( postingId );
    }

    public boolean isUp() {
        return VOTE.UP.equals( voted );
    }

    public boolean isDown() {
        return VOTE.DOWN.equals( voted );
    }
}
