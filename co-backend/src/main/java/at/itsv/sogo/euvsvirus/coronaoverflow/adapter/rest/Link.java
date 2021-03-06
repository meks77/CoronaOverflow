package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest;

import javax.ws.rs.Encoded;

public class Link {

    private final String action;
    @Encoded
    private final String url;
    private final Method method;

    public Link(String action, String url, Method method) {
        this.action = action;
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public Method getMethod() {
        return method;
    }

    public String getAction() {
        return action;
    }
}
