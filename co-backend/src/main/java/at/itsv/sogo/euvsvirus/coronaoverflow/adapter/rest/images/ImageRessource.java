package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.images;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.images.ImageRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("images")
public class ImageRessource {

    @Inject
    ImageRepository repo;

    @GET
    @Path("{imageId}")
    @Produces("image/png")
    public byte[] loadImageFromRessources(@PathParam("imageId") String imageId){
        byte[] image = repo.findImageForId( imageId );
        return image;
    }

}
