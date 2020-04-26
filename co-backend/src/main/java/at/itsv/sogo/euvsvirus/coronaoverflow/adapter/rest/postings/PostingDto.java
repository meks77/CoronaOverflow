package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

public class PostingDto {

    private String postingID;
    private String userID;
    private String date;
    private String title;
    private String text;
    private VotesDto votings;
    private Image image;

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

    public VotesDto getVotings() {
        return votings;
    }

    public Image getImage() {
        return image;
    }

    public static final class PostingDtoBuilder {
        private String postingID;
        private String userID;
        private String date;
        private String title;
        private String text;
        private VotesDto votings;
        private Image image;

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
            this.votings = votes;
            return this;
        }

        public PostingDtoBuilder withImage(Image image) {
            this.image = image;
            return this;
        }

        public PostingDto build() {
            PostingDto postingDto = new PostingDto();
            postingDto.userID = this.userID;
            postingDto.title = this.title;
            postingDto.date = this.date;
            postingDto.text = this.text;
            postingDto.postingID = this.postingID;
            postingDto.votings = this.votings;
            postingDto.image = this.image;
            return postingDto;
        }
    }
}
