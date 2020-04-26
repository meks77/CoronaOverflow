package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.trends;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Link;

public class TrendDto {

    private final String label;
    private final Link link;

    TrendDto(String label, Link link) {
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
