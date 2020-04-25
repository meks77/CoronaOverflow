package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

public class VotesDto {

    private final int up;
    private final int down;

    public VotesDto(int up, int down) {
        this.up = up;
        this.down = down;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }
}
