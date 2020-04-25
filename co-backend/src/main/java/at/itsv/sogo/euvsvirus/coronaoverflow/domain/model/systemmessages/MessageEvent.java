package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.systemmessages;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.ErrorMessage;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

public class MessageEvent {
    ErrorMessage message;
    UserId target;

    public MessageEvent(ErrorMessage message, UserId target) {
        this.message = message;
        this.target = target;
    }

    public ErrorMessage getMessage() {
        return message;
    }

    public UserId getTarget() {
        return target;
    }
}
