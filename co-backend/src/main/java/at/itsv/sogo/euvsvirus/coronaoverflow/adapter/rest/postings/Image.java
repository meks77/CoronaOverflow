package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

public class Image {

    private final String name;
    private final String mimeType;
    private final String content;

    public Image(String name, String mimeType, String content) {
        this.name = name;
        this.mimeType = mimeType;
        this.content = content;
    }

}
