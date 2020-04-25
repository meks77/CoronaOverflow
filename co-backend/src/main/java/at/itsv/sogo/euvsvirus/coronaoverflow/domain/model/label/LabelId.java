package at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Id;

public class LabelId extends Id {

    public LabelId(String uuid) {
        super(uuid);
    }

    @Override
    protected String contextPath() {
        return "labels/";
    }
}
