package at.itsv.sogo.euvsvirus.coronaoverflow.infrastructure.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LABELS")
public class LabelDbEntity extends PanacheEntity {

    public String name;

}
