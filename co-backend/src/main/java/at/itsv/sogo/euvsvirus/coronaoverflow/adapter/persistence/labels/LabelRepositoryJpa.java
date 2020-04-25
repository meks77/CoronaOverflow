package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.labels;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.label.LabelRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;


@ApplicationScoped
public class LabelRepositoryJpa implements LabelRepository {

    @Inject
    LabelDbEntityTranslator labelTranslator;

    @Override
    public Collection<Label> getAllLables() {
        return LabelDbEntity.<LabelDbEntity>findAll().stream()
                .map(labelTranslator::translate)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(String labelText) {
        if(LabelDbEntity.findByName( labelText ).isPresent() ) {
            return;
        }

        LabelDbEntity.persist( new LabelDbEntity( labelText ));
    }
}
