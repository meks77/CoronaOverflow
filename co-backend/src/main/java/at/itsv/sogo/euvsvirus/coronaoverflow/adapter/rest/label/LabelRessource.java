package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.label;

import at.itsv.sogo.euvsvirus.coronaoverflow.model.repos.LabelRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/labels")
public class LabelRessource {

    @Inject
    LabelRepository labelRepo;

    @Inject
    LabelTranslator labelTranslator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<LabelInfo> hello() {
        return labelRepo.getAllLables().stream().map(labelTranslator::from).collect(Collectors.toList());
    }

}