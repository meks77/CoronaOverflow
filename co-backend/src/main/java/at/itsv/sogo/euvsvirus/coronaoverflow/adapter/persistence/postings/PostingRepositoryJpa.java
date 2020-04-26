package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.labels.LabelDbEntity;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Trend;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.service.postings.PostingRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@ApplicationScoped
@Transactional
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
            .map(translator::translateToDomain)
            .collect(toList());
    }

    @Override
    public Collection<Posting> findAllPostingsByUser(UserId user) {
        return PostingDbEntity.findByUser( user ).stream().map( translator::translateToDomain).collect(toList());
    }


    @Override
    public Optional<Posting> findByID(PostingId id) {
        final Optional<PostingDbEntity> postingDbEntity = PostingDbEntity.findByID(id.val());
        if (!postingDbEntity.isPresent()) {
            return Optional.empty();
        }
        return postingDbEntity.map(translator::translateToDomain);
    }

    @Override
    public void save(Posting newPosting) {
        translator.translateToDb(newPosting).persist();
    }
}
