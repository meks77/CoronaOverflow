package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.labels;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Link;

public class LabelDto {

    private final String label;
    private final Link link;

    LabelDto(String label, Link link) {
        this.label = label;
        this.link = link;
    }

    public String getLabel() {
        return label;
    }

    public Link getLink() {
        return link;
    }
}
