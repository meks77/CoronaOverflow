package at.itsv.sogo.euvsvirus.coronaoverflow.model.repos;

import at.itsv.sogo.euvsvirus.coronaoverflow.model.aggregates.Label;

import java.util.Collection;

public interface LabelRepository {

    Collection<Label> getAllLables();
}
