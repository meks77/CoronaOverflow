package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.postings;

import at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.labels.LabelDbEntity;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.LabelId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Image;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingProperties;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingText;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Timestamp;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class PostingDbEntityTranslator {

    public Posting translateToDomain(PostingDbEntity postingDbEntity) {
        return Posting.create(
                new PostingProperties(
                        new PostingId(postingDbEntity.uuid),
                        new Timestamp(postingDbEntity.created),
                        new UserId(postingDbEntity.userId),
                        new Title(postingDbEntity.title),
                        new LabelId(String.valueOf(postingDbEntity.label.id)),
                        new PostingText(postingDbEntity.text),
                        new Image(postingDbEntity.imageName)));
    }

    public PostingDbEntity translateToDb(Posting newPosting) {
        final PostingDbEntity dbEntity = new PostingDbEntity();
        dbEntity.created = newPosting.created().timestamp();
        dbEntity.label = LabelDbEntity.findByName(newPosting.labelId().val())
                .orElseThrow(() -> new IllegalArgumentException(String.format("label %s not found", newPosting.labelId().val())));
        dbEntity.text = newPosting.text().text();
        dbEntity.title = newPosting.title().text();
        dbEntity.userId = newPosting.userId().val();
        dbEntity.uuid = newPosting.id().val();

        newPosting.image().ifPresent(image -> dbEntity.imageName = image.name());
        return dbEntity;
    }
}
