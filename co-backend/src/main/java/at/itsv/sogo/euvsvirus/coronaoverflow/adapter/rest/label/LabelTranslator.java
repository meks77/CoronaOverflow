package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.label;

import at.itsv.sogo.euvsvirus.coronaoverflow.model.aggregates.Label;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class LabelTranslator {

    LabelInfo from(Label label) {
        return new LabelInfo(label.name().text(),
                new Link("/label/" + label.name().text(), Method.GET));
    }
}
