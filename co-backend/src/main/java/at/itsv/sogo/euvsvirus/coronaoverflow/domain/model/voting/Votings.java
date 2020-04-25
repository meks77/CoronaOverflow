package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.AggregateRoot;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.ErrorMessage;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Votes;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AggregateRoot
public class Votings {
    private PostingId post;
    private List<Vote> votes;

    public Votings(PostingId post, List<Vote> votes) {
        this.post = post;
        this.votes = new ArrayList<>(votes);
    }

    public Optional<ErrorMessage> addVote(Vote vote) {
        // TODO: check invariant => No double voting, define if we throw error or replace an already existing vote?
        votes.add( vote );
        return Optional.empty();
    }

    public long amountUp() {
        return votes.stream().filter(Vote::isUp).count();
    }
    public long amountDown() {
        return votes.stream().filter(Vote::isDown).count();
    }

    public Optional<Vote> voteForUser(UserId userId) {
        return votes.stream().filter( v -> userId.equals( v.user() )).findFirst();
    }
}
