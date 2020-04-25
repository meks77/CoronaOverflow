package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model;

import java.util.Objects;

public abstract class Id {

    private final String uuid;

    public Id(String uuid) {
        Objects.requireNonNull(uuid);
        this.uuid = uuid;
    }

    public String val() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Id)) return false;
        Id id = (Id) o;
        return Objects.equals(uuid, id.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
