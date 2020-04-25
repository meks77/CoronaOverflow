package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.labels;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Name;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class LabelDbEntityTranslator {

    Label translate(LabelDbEntity dbEntity) {
        return new Label(new Name(dbEntity.name));
    }
}
