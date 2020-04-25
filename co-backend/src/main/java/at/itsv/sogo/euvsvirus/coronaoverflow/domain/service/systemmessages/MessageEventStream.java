package at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.systemmessages;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.ErrorMessage;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.systemmessages.Error;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.systemmessages.MessageEvent;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@RequestScoped
public class MessageEventStream {

    @Inject @Error
    Event<MessageEvent> event;

    public void sendError(ErrorMessage message, UserId user){
        event.fire( new MessageEvent( message, user ));
    }

}
