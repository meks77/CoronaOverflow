package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Name;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.repos.PostingRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/postings")
@Produces(MediaType.APPLICATION_JSON)
public class PostingsResource {

    @Inject
    PostingRepository postingRepo;

    @Inject
    PostingTranslator postingTranslator;

    @GET
    @Path("/forLabel/{label}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostingDto> getPosting(@PathParam("label") String label) {
        return postingRepo.findAllByLabel(new Label(new Name(label)))
                .stream()
                .map(postingTranslator::translate)
                .collect(Collectors.toList());
    }

}
