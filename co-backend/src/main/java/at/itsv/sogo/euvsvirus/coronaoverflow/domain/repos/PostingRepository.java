package at.itsv.sogo.euvsvirus.coronaoverflow.domain.repos;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;

import java.util.Collection;

public interface PostingRepository {

    Collection<Posting> findAllByLabel(Label label);

}
