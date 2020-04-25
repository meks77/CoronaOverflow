package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.labels;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.repos.LabelRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
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

    @GET
    public List<LabelDto> getAllLabels() {
        return labelRepo.getAllLables().stream().map(labelTranslator::from).collect(Collectors.toList());
    }

}