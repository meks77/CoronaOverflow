package at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.ErrorMessage;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Vote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Votings;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.postings.PostingRepository;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.systemmessages.MessageEventStream;

import javax.inject.Inject;
import java.util.Optional;

public class VotingService {

    @Inject
    MessageEventStream messages;

    @Inject
    VotingsRepository votingRepo;

    public void vote(PostingId postingId, Vote vote){
        Votings votings = votingRepo.loadVotings( postingId);
        votings.addVote(vote ).ifPresent( error -> messages.sendError( error, vote.user() ) );
        votingRepo.save(votings);
    }

}
