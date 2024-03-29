package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.votings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.DownVote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.voting.UpVote;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings.VotingService;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("voting")
public class VotingsRessource {

    @Inject
    VotingService service;

    @PUT
    @Path("{postingId}/voteUp")
    @Operation(summary = "vote up for a posting")
    public Response voteUp( @PathParam("postingId") String postingId, @HeaderParam("X-CO-USERID") String userId){
        service.vote( new PostingId( postingId ), new UpVote(new UserId(userId)));
        return Response.ok().build();
    }

    @PUT
    @Path("{postingId}/voteDown")
    @Operation(summary = "vote down for a posting")
    public Response voteDown( @PathParam("postingId") String postingId, @HeaderParam("X-CO-USERID") String userId){
        service.vote( new PostingId( postingId ), new DownVote(new UserId(userId)));
        return Response.ok().build();
    }

}
