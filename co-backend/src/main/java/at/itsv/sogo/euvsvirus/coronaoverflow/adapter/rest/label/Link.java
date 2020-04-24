package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.label;

public class Link {

    private final String url;
    private final Method method;

    Link(String url, Method method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public Method getMethod() {
        return method;
    }
}
