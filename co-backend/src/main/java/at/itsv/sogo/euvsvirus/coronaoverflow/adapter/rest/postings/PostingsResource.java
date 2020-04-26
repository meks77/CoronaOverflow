package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.LabelId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Name;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.CreatePostingCmd;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingText;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.postings.PostingRepository;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.votings.VotingsRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    @Operation(summary = "get all posting of one label")
    public List<PostingDto> getPosting(@PathParam("label") String label, @HeaderParam("X-CO-USERID") String userId) {
        Comparator<PostingDto> byRanking = Comparator.comparingDouble(c -> c.getVotings().getRanking());

        return postingRepo.findAllByLabel(new Label(new Name(label)))
                .stream()
                .map(posting -> postingTranslator.translate(posting, votingsRepo.loadVotings(posting.id()),
                        Optional.ofNullable(userId).map(UserId::new)))
                .sorted(byRanking.reversed())
                .collect(Collectors.toList());
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "create a new posting")
    public void createPosting(
            @Parameter(required = true, description = "the id of the user")
            @HeaderParam("X-CO-USERID")
                    String userId,
            @RequestBody(required = true, description = "the values of the new post" )
                    NewPostingDto posting) {
        final Posting newPosting = Posting.createNew(
                new CreatePostingCmd(new UserId(userId), new Title(posting.getTitle()),
                        new LabelId(posting.getLabel()), new PostingText(posting.getText())));
        postingRepo.save(newPosting);
    }


    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public PostingDto getPostingByID(@PathParam("uuid") String uuid, @HeaderParam("X-CO-USERID") String userId) {

        Optional<Posting> posting = postingRepo.findByID(new PostingId(uuid));
        if(posting.isPresent()) {
            return postingTranslator.translate(posting.get(), votingsRepo.loadVotings(posting.get().id()), Optional.ofNullable(userId).map(UserId::new));
        }
        else {
            throw new IllegalStateException();
        }
    }

}
