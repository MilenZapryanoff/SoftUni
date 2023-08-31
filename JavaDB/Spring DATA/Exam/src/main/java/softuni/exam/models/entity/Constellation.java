package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToMany(mappedBy = "constellation")
    private Set<Star> stars;


    public Constellation() {
        stars = new HashSet<>();
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Star> getStars() {
        return stars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStars(Set<Star> stars) {
        this.stars = stars;
    }
}
