package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

public class ErrorMessage {
    private String summary;
    private String text;

    public ErrorMessage( String summary, String text) {
        this.summary = summary;
        this.text = text;
    }

}
