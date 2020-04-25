package at.itsv.sogo.euvsvirus.coronaoverflow.infrastructure;

import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Label;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.Title;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.CreatePostingCmd;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Id;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.Posting;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.model.posting.PostingText;
import at.itsv.sogo.euvsvirus.coronaoverflow.domain.repos.PostingRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@ApplicationScoped
public class PostingRepositoryImpl implements PostingRepository {

    @Override
    public Collection<Posting> findAllByLabel(Label label) {
        return Collections.singletonList(
                new Posting(
                        new CreatePostingCmd(
                                new Id(UUID.randomUUID().toString()),
                                new Title("temp posting title"),
                                new Id("labelId"),
                                new PostingText("temp posting text"))));
    }
}
