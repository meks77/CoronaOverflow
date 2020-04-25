package at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Vote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Votings;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.systemmessages.MessageEventStream;

import javax.inject.Inject;
import javax.inject.Named;

@Named
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
