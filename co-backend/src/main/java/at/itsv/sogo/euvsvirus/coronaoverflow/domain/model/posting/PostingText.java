package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;

import java.util.Objects;

public class PostingText {

    private final String text;

    public PostingText(String text) {
        Objects.requireNonNull(text);
        if (text.length() == 0) {
            throw new IllegalArgumentException("text length must be greater than 0");
        }
        this.text = text;
    }

    public String text() {
        return text;
    }

}
