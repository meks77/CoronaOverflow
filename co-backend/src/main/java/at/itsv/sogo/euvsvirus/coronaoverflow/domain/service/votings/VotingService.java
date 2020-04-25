package at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.ErrorMessage;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Vote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Votings;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.systemmessages.MessageEventStream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
@ApplicationScoped
public class VotingService {

    @Inject
    MessageEventStream messages;

    @Inject
    VotingsRepository votingRepo;

    public void vote(PostingId postingId, Vote vote){
        Votings votings = votingRepo.loadVotings( postingId);
        final Optional<ErrorMessage> addResult = votings.addVote(vote);
        addResult.ifPresent( error -> messages.sendError( error, vote.user() ) );

        votingRepo.save(votings);
    }

}
