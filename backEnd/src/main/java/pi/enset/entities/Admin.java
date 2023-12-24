package pi.enset.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import pi.enset.entities.enums.TypeAdmin;

import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ADMIN")
//@Getter
//@Setter
public class Admin extends Person {
    @Enumerated(EnumType.STRING)
    private TypeAdmin admin_type;
    @OneToMany(mappedBy = "enseignant", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<NonDisponibilite> nonDisponibilites = new ArrayList<>();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "enseignant")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ElementDeModule> elementDeModules = new ArrayList<>();

    public TypeAdmin getAdmin_type() {
        return admin_type;
    }

    public void setAdmin_type(TypeAdmin admin_type) {
        this.admin_type = admin_type;
    }

    public Collection<NonDisponibilite> getNonDisponibilites() {
        return nonDisponibilites;
    }

    public void setNonDisponibilites(Collection<NonDisponibilite> nonDisponibilites) {
        this.nonDisponibilites = nonDisponibilites;
    }

    public Collection<ElementDeModule> getElementDeModules() {
        return elementDeModules;
    }

    public void setElementDeModules(Collection<ElementDeModule> elementDeModules) {
        this.elementDeModules = elementDeModules;
    }
}
