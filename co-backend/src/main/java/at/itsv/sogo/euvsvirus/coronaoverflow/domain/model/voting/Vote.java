package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

public abstract class Vote {
    enum VOTE { UP, DOWN }

    private VOTE vote;
    private UserId user;

    public Vote(VOTE vote, UserId user) {
        this.vote = vote;
        this.user = user;
    }
    public boolean isUp(){
        return VOTE.UP.equals( vote );
    }

    public boolean isDown(){
        return VOTE.DOWN.equals( vote );
    }

    public UserId user() {
        return user;
    }
}
