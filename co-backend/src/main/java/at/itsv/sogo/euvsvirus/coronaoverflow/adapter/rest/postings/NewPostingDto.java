package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

public class NewPostingDto {

    private String title;
    private String text;
    private String label;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
