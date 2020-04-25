package at.itsv.sogo.euvsvirus.coronaoverflow.domain.repos;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Label;

import java.util.Collection;

public interface LabelRepository {

    Collection<Label> getAllLables();
}
