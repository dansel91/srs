package ch.bfh.srs.srv.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author zinggpa
 */
@Entity
public class Reservation {
    @Id
    @Column(name = "id_reservation")
    private Integer idReservation;

    @Basic
    @Column(name = "from")
    private Timestamp from;

    @Basic
    @Column(name = "to")
    private Timestamp to;

    @Basic
    @Column(name = "full_day")
    private Timestamp fullDay;

    @ManyToOne(optional = false)
    @JoinColumn(name = "resource_id", referencedColumnName = "id_resource")
    private Resource resource;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id_user")
    private User user;

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }

    public Timestamp getFullDay() {
        return fullDay;
    }

    public void setFullDay(Timestamp fullDay) {
        this.fullDay = fullDay;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
