package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model;

import java.util.Objects;

public class Title {

    private final String text;

    public Title(String text) {
        Objects.requireNonNull(text);
        this.text = text;
    }

    public String text() {
        return text;
    }
}
