package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private long capaciteFoyer;

    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    @JsonIgnore
    private Set<Bloc> blocs;

    public Foyer(Long l, String f1, int i, Object o, Object o1) {
    }

    public Foyer() {

    }

    // Getters & Setters
    public Long getIdFoyer() { return idFoyer; }
    public void setIdFoyer(Long idFoyer) { this.idFoyer = idFoyer; }

    public String getNomFoyer() { return nomFoyer; }
    public void setNomFoyer(String nomFoyer) { this.nomFoyer = nomFoyer; }

    public long getCapaciteFoyer() { return capaciteFoyer; }
    public void setCapaciteFoyer(long capaciteFoyer) { this.capaciteFoyer = capaciteFoyer; }

    public Universite getUniversite() { return universite; }
    public void setUniversite(Universite universite) { this.universite = universite; }

    public Set<Bloc> getBlocs() { return blocs; }
    public void setBlocs(Set<Bloc> blocs) { this.blocs = blocs; }
}
