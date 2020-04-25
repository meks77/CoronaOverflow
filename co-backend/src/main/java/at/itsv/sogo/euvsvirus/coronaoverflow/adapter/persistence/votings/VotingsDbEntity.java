package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.votings;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "VOTINGS")
public class VotingsDbEntity extends PanacheEntity {
    enum VOTE { UP, DOWN }

    @Column(name="USER_ID")
    public String userId;

    @Column(name="POST_ID")
    public String postingId;

    @Column(name="VOTED")
    @Enumerated(EnumType.STRING)
    public VOTE voted;

    public boolean isUp() {
        return VOTE.UP.equals( voted );
    }

    public boolean isDown() {
        return VOTE.DOWN.equals( voted );
    }
}
