package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.votings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.DownVote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.UpVote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings.VotingService;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("voting")
public class VotingsRessource {

    VotingService service;

    @PUT
    @Path("{postingId}/voteUp")
    public Response voteUp( @PathParam("postingId") String postingId){
        service.vote( new PostingId( postingId ), new UpVote(new UserId("blaaa")));
        return Response.ok().build();
    }

    @PUT
    @Path("{postingId}/voteDown")
    public Response voteDown( @PathParam("postingId") String postingId){
        service.vote( new PostingId( postingId ), new DownVote(new UserId("blaaa")));
        return Response.ok().build();
    }

}
