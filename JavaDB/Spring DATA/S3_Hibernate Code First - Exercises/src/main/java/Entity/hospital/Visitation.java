package Entity.hospital;

import Entity.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private LocalDateTime visitationDate;
    private String comment;
    private Patient patient;

    public Visitation() {
    }

    @ManyToOne()
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Column(name = "visitation_date", nullable = false)
    public LocalDateTime getVisitationDate() {
        return visitationDate;
    }

    public void setVisitationDate(LocalDateTime visitationDate) {
        this.visitationDate = visitationDate;
    }

    @Column(name = "comments", columnDefinition = "TEXT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
