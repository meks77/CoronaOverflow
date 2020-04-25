package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Votes;

public class PostingDto {

    private String postingID;
    private String userID;
    private String date;
    private String title;
    private String text;
    private VotesDto votes;
    private boolean voted;

    public String getPostingID() {
        return postingID;
    }

    public String getUserID() {
        return userID;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public VotesDto getVotes() {
        return votes;
    }

    public boolean isVoted() {
        return voted;
    }

    public static final class PostingDtoBuilder {
        private String postingID;
        private String userID;
        private String date;
        private String title;
        private String text;
        private VotesDto votes;

        private PostingDtoBuilder() {
        }

        public static PostingDtoBuilder aPostingDto() {
            return new PostingDtoBuilder();
        }

        public PostingDtoBuilder withPostingID(String postingID) {
            this.postingID = postingID;
            return this;
        }

        public PostingDtoBuilder withUserID(String userID) {
            this.userID = userID;
            return this;
        }

        public PostingDtoBuilder withDate(String date) {
            this.date = date;
            return this;
        }

        public PostingDtoBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public PostingDtoBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public PostingDtoBuilder withVotes(VotesDto votes ){
            this.votes = votes;
            return this;
        }

        public PostingDto build() {
            PostingDto postingDto = new PostingDto();
            postingDto.userID = this.userID;
            postingDto.title = this.title;
            postingDto.date = this.date;
            postingDto.text = this.text;
            postingDto.postingID = this.postingID;
            postingDto.votes = this.votes;
            return postingDto;
        }
    }
}
