package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.labels;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Link;
import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Method;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;

import javax.enterprise.context.ApplicationScoped;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@ApplicationScoped
class LabelTranslator {

    LabelDto from(Label label) {
        try {
            return new LabelDto(label.name().text(),
                    new Link("view", "/postings/forLabel/" + URLEncoder.encode(label.name().text(), "UTF-8").replace("+", "%20"), Method.GET));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException( e );
        }
    }
}
