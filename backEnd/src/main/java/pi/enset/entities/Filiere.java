package pi.enset.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private int nombreSem;
    private String chefFiliere; // ?
    @OneToMany(mappedBy = "filiere")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Classe> classes = new ArrayList<>();
    @ManyToOne
    private Departement departement;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNombreSem() {
        return nombreSem;
    }

    public void setNombreSem(int nombreSem) {
        this.nombreSem = nombreSem;
    }

    public String getChefFiliere() {
        return chefFiliere;
    }

    public void setChefFiliere(String chefFiliere) {
        this.chefFiliere = chefFiliere;
    }

    public Collection<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Classe> classes) {
        this.classes = classes;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
