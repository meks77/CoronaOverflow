package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.ValueObject;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

@ValueObject
public class UpVote extends Vote {
    public UpVote(UserId user) {
        super(VOTE.UP, user);
    }
}
