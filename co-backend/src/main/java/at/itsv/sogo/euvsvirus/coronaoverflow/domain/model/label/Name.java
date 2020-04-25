package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.ValueObject;

@ValueObject
public class Name {

    private final String text;

    public Name(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
