package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Name;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.postings.PostingRepository;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings.VotingsRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/postings")
@Produces(MediaType.APPLICATION_JSON)
public class PostingsResource {

    @Inject
    PostingRepository postingRepo;

    @Inject
    VotingsRepository votingsRepo;

    @Inject
    PostingTranslator postingTranslator;

    @GET
    @Path("/forLabel/{label}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostingDto> getPosting(@PathParam("label") String label, @HeaderParam("X-CO-USERID") String userId) {
        return postingRepo.findAllByLabel(new Label(new Name(label)))
                .stream()
                .map( posting -> postingTranslator.translate(posting, votingsRepo.loadVotings( posting.id() ), Optional.ofNullable( userId).map( UserId::new)))
                .sorted(Comparator.comparingDouble( c -> c.getVotings().getRanking() ))
                .collect(Collectors.toList());
    }

}
