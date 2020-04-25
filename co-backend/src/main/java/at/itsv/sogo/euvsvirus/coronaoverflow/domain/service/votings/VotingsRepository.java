package at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Votings;

public interface VotingsRepository {
    Votings loadVotings(PostingId postingId);

    void save(Votings votings);
}
