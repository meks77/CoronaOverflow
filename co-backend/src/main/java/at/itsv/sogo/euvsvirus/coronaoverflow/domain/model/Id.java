package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model;

import java.util.Objects;

public abstract class Id {

    private final String uuid;

    public Id(String uuid) {
        Objects.requireNonNull(uuid);
        this.uuid = uuid;
    }

    public String asLink() {
        return contextPath() + uuid;
    }

    protected abstract String contextPath();

}
