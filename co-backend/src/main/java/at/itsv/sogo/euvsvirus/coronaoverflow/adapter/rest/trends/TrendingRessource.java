package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.trends;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Link;
import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.rest.Method;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/trends")
@Produces(MediaType.APPLICATION_JSON)
public class TrendingRessource {

    @GET
    @Operation(summary = "get all Trends")
    public List<TrendDto> getAllTrends() {
        return Arrays.asList(
                new TrendDto("Top 10", new Link("topten", "/postings/trends/topten", Method.GET)),
                new TrendDto("Trending in Austria", new Link("top-who", "/postings/trends/trending-who", Method.GET))
        );
    }
}
