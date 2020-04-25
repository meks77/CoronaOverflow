package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.ValueObject;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

@ValueObject
public class DownVote extends Vote {
    public DownVote(UserId user) {
        super(VOTE.DOWN, user);
    }
}
