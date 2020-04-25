package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.votings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.DownVote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.UpVote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Vote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.Votings;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings.VotingsRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@Transactional
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
        return entity.isDown() ? new DownVote(new UserId(entity.userId)) : new UpVote(new UserId(entity.userId));
    }

    @Override
    public void save(Votings votings) {
        final List<VotingsDbEntity> dbVotings = VotingsDbEntity.list("postingId",
                votings.post().val());

        votings.votes().forEach(vote -> saveOrUpdate(vote, dbVotings, votings.post()));
    }

    private void saveOrUpdate(Vote vote, List<VotingsDbEntity> dbVotings, PostingId post) {
        vote.user();
        final Optional<VotingsDbEntity> dbEntity = dbVotings.stream()
                .filter(votingDbEntity -> votingDbEntity.userId.equals(vote.user().val()))
                .findFirst();
        if (!dbEntity.isPresent()) {
            VotingsDbEntity newVoting = new VotingsDbEntity();
            newVoting.voted = getVoteUpOrDown(vote);
            newVoting.userId = vote.user().val();
            newVoting.postingId = post.val();
            newVoting.persist();
        } else if (dbEntity.get().isUp() && vote.isDown()) {
            dbEntity.get().voted = VotingsDbEntity.VOTE.DOWN;
            dbEntity.get().persist();
        } else if (dbEntity.get().isDown() && vote.isUp()) {
            dbEntity.get().voted = VotingsDbEntity.VOTE.UP;
            dbEntity.get().persist();
        }
    }

    private VotingsDbEntity.VOTE getVoteUpOrDown(Vote vote) {
        return vote.isUp() ? VotingsDbEntity.VOTE.UP : VotingsDbEntity.VOTE.DOWN;
    }
}
