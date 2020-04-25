package at.itsv.sogo.euvsvirus.coronaoverflow.infrastructure;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.LabelId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.label.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.CreatePostingCmd;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Id;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingText;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.user.UserId;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.repos.PostingRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@ApplicationScoped
public class PostingRepositoryStub implements PostingRepository {

    @Override
    public Collection<Posting> findAllByLabel(Label label) {
        return Collections.singletonList(
                new Posting(
                        new CreatePostingCmd(
                                new UserId(UUID.randomUUID().toString()),
                                new Title("temp posting title"),
                                new LabelId("labelId"),
                                new PostingText("temp posting text"))));
    }
}
