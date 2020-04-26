package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.images;

import org.apache.commons.io.IOUtils;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
public class ImageRepository {

    public byte[] findImageForId(String imageId) {
        try {
            return IOUtils.toByteArray(getClass().getResourceAsStream("/" + imageId));
        } catch (IOException e) {
            throw new IllegalStateException("error while reading dummy picture", e);
        }
    }

}
