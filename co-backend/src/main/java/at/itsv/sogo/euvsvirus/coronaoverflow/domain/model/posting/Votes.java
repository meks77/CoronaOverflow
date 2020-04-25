package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.ValueObject;

@ValueObject
public class Votes {

    private int upVotes;

    private int downVotes;

    public int upVotes() {
        return upVotes;
    }

    public int downVotes() {
        return downVotes;
    }
}
