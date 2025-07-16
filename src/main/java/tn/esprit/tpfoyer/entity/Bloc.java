package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;
    private long capaciteBloc;

    @ManyToOne
    @JoinColumn(name = "foyer_id")
    @JsonIgnore
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    @JsonIgnore
    private Set<Chambre> chambres;

    // Getters & Setters
    public Long getIdBloc() { return idBloc; }
    public void setIdBloc(Long idBloc) { this.idBloc = idBloc; }

    public String getNomBloc() { return nomBloc; }
    public void setNomBloc(String nomBloc) { this.nomBloc = nomBloc; }

    public long getCapaciteBloc() { return capaciteBloc; }
    public void setCapaciteBloc(long capaciteBloc) { this.capaciteBloc = capaciteBloc; }

    public Foyer getFoyer() { return foyer; }
    public void setFoyer(Foyer foyer) { this.foyer = foyer; }

    public Set<Chambre> getChambres() { return chambres; }
    public void setChambres(Set<Chambre> chambres) { this.chambres = chambres; }
}
