package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.label;

public class LabelInfo {

    private final String label;
    private final Link link;

    LabelInfo(String label, Link link) {
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
