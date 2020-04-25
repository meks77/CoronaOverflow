package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.labels;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.label.LabelRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    @Operation(summary = "create a new label")
    public List<LabelDto> createLabel(@HeaderParam("X-CO-LABEL") String labelText ){
        labelRepo.create( labelText );
        return getAllLabels();
    }

    @GET
    @Operation(summary = "get all labels")
    public List<LabelDto> getAllLabels() {
        return labelRepo.getAllLables().stream().map(labelTranslator::from).collect(Collectors.toList());
    }

}