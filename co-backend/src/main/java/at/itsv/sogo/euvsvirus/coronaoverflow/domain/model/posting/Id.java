package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;

import java.util.Objects;

public class Id {

    private final String asText;

    public Id(String asText) {
        Objects.requireNonNull(asText);
        this.asText = asText;
    }

    public String asText() {
        return asText;
    }
}
