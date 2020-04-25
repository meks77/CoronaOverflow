package at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

import javax.inject.Inject;

public class VotingService {

    @Inject
    PostingRepository repo;

    public void thumbUp(PostingId id, UserId user){
        //Posting posting = repo.findBy( id );
    }

    public void thumbDown(PostingId id, UserId user){

    }
}
