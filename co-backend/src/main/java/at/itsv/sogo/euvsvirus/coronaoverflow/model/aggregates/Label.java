package at.itsv.sogo.euvsvirus.coronaoverflow.model.aggregates;

public class Label {

    private final Name name;

    public Label(Name name) {
        this.name = name;
    }

    public Name name() {
        return name;
    }
}
