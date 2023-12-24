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
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String chefDepartement;
    @OneToMany(mappedBy = "departement", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Filiere> filieres = new ArrayList<>();

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

    public String getChefDepartement() {
        return chefDepartement;
    }

    public void setChefDepartement(String chefDepartement) {
        this.chefDepartement = chefDepartement;
    }

    public Collection<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(Collection<Filiere> filieres) {
        this.filieres = filieres;
    }
}
