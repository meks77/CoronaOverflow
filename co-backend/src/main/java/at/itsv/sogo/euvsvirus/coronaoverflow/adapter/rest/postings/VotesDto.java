package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Link;

import java.util.List;

public class VotesDto {

    private final long up;
    private final long down;
    private final String voted;
    private final List<Link> links;

    public VotesDto(long up, long down, String votedByUser, List<Link> links) {
        this.up = up;
        this.down = down;
        this.voted = votedByUser;
        this.links = links;
    }

    public long getUp() {
        return up;
    }

    public long getDown() {
        return down;
    }

    public String getVoted() {
        return voted;
    }

    public List<Link> getLinks() {
        return links;
    }
}
