package Entity.hospital;

import Entity.BaseEntity;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private Blob picture;
    private boolean isInsured;
    private Set<Diagnose> diagnoses;
    private Set<Medicament> medicaments;
    private Set<Visitation> visitations;

    public Patient() {
        this.diagnoses = new HashSet<>();
        this.medicaments = new HashSet<>();
        this.visitations = new HashSet<>();
    }

    public Patient(String firstName, String lastName, String address, String email, LocalDate date, boolean isInsured) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.dateOfBirth = date;
        this.isInsured = isInsured;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth", columnDefinition = "DATE")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "picture")
    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    @Column(name = "insurance")
    public boolean isInsured() {
        return isInsured;
    }

    public void setInsured(boolean insured) {
        isInsured = insured;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }
}
