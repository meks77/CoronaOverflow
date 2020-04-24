package at.itsv.sogo.euvsvirus.coronaoverflow.infrastructure;

import at.itsv.sogo.euvsvirus.coronaoverflow.infrastructure.entities.LabelDbEntity;
import at.itsv.sogo.euvsvirus.coronaoverflow.model.aggregates.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.model.repos.LabelRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.stream.Collectors;


@ApplicationScoped
public class LabelRepositoryImpl implements LabelRepository {

    @Inject
    LabelDbEntityTranslator labelTranslator;

    @Override
    public Collection<Label> getAllLables() {
        return LabelDbEntity.<LabelDbEntity>findAll().stream()
                .map(labelTranslator::translate)
                .collect(Collectors.toList());
    }
}
