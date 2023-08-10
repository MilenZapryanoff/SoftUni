package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "mechanics")
public class Mechanic extends BaseEntity {
    @Column(name = "first_name", unique = true, nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "phone", unique = true)
    private String phone;
    @OneToMany(mappedBy = "mechanic", fetch = FetchType.EAGER)
    private Set<Task> tasks;

    public Mechanic() {
        tasks = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
