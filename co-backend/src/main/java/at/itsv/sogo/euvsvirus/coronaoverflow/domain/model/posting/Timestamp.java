package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting;

import java.time.ZonedDateTime;
import java.util.Objects;

public class Timestamp {

    private final ZonedDateTime timestamp;

    public Timestamp(ZonedDateTime timestamp) {
        Objects.requireNonNull(timestamp);
        this.timestamp = ZonedDateTime.from(timestamp);
    }

    public ZonedDateTime timestamp() {
        return timestamp;
    }
}
