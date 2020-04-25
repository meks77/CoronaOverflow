package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.labels;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Link;
import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Method;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class LabelTranslator {

    LabelDto from(Label label) {
        return new LabelDto(label.name().text(),
                new Link("view", "/postings/forLabel/" + label.name().text(), Method.GET));
    }
}
