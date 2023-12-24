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
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int volumeHoraire;
    private String libelle;
    private boolean isSeperated;
    private boolean isMetuale;
    @OneToMany(mappedBy = "module", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ElementDeModule> elementDeModules = new ArrayList<>();
    @ManyToOne
    private Classe classe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(int volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public boolean isSeperated() {
        return isSeperated;
    }

    public void setSeperated(boolean seperated) {
        isSeperated = seperated;
    }

    public boolean isMetuale() {
        return isMetuale;
    }

    public void setMetuale(boolean metuale) {
        isMetuale = metuale;
    }

    public Collection<ElementDeModule> getElementDeModules() {
        return elementDeModules;
    }

    public void setElementDeModules(Collection<ElementDeModule> elementDeModules) {
        this.elementDeModules = elementDeModules;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
