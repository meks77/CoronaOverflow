package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.labels;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.label.LabelRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/labels")
@Produces(MediaType.APPLICATION_JSON)
public class LabelsRessource {

    @Inject
    LabelRepository labelRepo;

    @Inject
    LabelTranslator labelTranslator;

    @POST
    public Response createLabel(@HeaderParam("X-CO-LABEL") String labelText ){
        labelRepo.create( labelText );
        return Response.ok().build();
    }

    @GET
    public List<LabelDto> getAllLabels() {
        return labelRepo.getAllLables().stream().map(labelTranslator::from).collect(Collectors.toList());
    }

}