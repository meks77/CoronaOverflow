package at.itsv.sogo.euvsvirus.coronaoverflow.infrastructure;

import at.itsv.sogo.euvsvirus.coronaoverflow.model.aggregates.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.model.aggregates.Name;
import at.itsv.sogo.euvsvirus.coronaoverflow.model.repos.LabelRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.Collection;


@ApplicationScoped
public class LabelRepositoryImpl implements LabelRepository {

    @Override
    public Collection<Label> getAllLables() {
        return Arrays.asList(new Label(new Name("label1")),
                new Label(new Name("label2")),
                new Label(new Name("label3"))
        );
    }
}
