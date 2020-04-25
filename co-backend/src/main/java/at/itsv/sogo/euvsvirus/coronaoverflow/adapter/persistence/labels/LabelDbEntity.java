package at.itsv.sogo.euvsvirus.coronaoverflow.adapter.persistence.labels;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Optional;

@Entity
@Table(name = "LABELS")
public class LabelDbEntity extends PanacheEntity {

    public String name;

    public LabelDbEntity() {
    }

    public LabelDbEntity( String name ) {
        this.name = name;
    }

    public static Optional<LabelDbEntity> findByName(String name) {
        return find("name", name).singleResultOptional();
    }
}
