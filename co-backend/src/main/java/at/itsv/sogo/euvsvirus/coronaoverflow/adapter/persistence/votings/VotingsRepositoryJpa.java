package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.votings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.DownVote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.UpVote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Vote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Votings;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings.VotingsRepository;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

public class VotingsRepositoryJpa implements VotingsRepository {
    @Override
    public Votings loadVotings(PostingId postingId) {
        List<Vote> votes = VotingsDbEntity.<VotingsDbEntity>list("postingId", postingId.val())
                .stream()
                .map(this::asVote)
                .collect(Collectors.toList());

        return new Votings(postingId, votes);
    }

    private Vote asVote(VotingsDbEntity entity) {
        return entity.isDown() ? new DownVote( entity.user() ) : new UpVote( entity.user() );
    }

    @Override
    public void save(Votings votings) {
        //TODO: persist stuff!
    }
}
