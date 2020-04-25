package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Id;

public class UserId extends Id {

    public UserId(String uniqueId) {
        super(uniqueId);
    }

    @Override
    protected String contextPath() {
        return "user/";
    }
}
