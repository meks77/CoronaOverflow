package at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;

import java.util.Collection;
import java.util.Optional;

public interface PostingRepository {

    Collection<Posting> findAllByLabel(Label label);

    Optional<Posting> findBy(PostingId id);
}
