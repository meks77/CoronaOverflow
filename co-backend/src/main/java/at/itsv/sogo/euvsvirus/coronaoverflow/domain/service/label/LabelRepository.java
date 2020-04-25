package at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.label;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;

import java.util.Collection;

public interface LabelRepository {

    Collection<Label> getAllLables();

    void create(String labelText);
}
