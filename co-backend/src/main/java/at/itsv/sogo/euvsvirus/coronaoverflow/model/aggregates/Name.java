package at.itsv.sogo.euvsvirus.coronaoverflow.model.aggregates;

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
