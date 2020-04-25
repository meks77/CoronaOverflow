package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.labels.LabelDbEntity;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.postings.PostingRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class PostingRepositoryJpa implements PostingRepository {

    @Inject
    PostingDbEntityTranslator translator;

    @Override
    public Collection<Posting> findAllByLabel(Label label) {
        final Optional<LabelDbEntity> labelDbEntity = LabelDbEntity.findByName(label.name().text());
        if (!labelDbEntity.isPresent()) {
            return Collections.emptyList();
        }
        return PostingDbEntity.findByLabel(labelDbEntity.get()).stream()
            .map(translator::translate)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Posting> findByID(PostingId id) {
        final Optional<PostingDbEntity> postingDbEntity = PostingDbEntity.findByID(id.val());
        if (!postingDbEntity.isPresent()) {
            return Optional.empty();
        }
        return postingDbEntity.map(translator::translate);
    }
}
