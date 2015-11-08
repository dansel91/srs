/*
 * Copyright (c) 2015 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.srs.srv.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.sql.Timestamp;

@NamedQueries({
        @NamedQuery(name = Reservation.ALL_NQUERY,
                query = "select r from Reservation r"),
        @NamedQuery(name = Reservation.ID_NQUERY,
                query = "select t from Reservation t where t.idReservation = :id")
})
@Entity
public class Reservation {
    public static final String ALL_NQUERY = "res.all";
    public static final String ID_NQUERY = "res.id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Integer idReservation;

    @Basic
    @Column(name = "stmp_from")
    private Timestamp from;

    @Basic
    @Column(name = "stmp_to")
    private Timestamp to;

    @Basic
    @Column(name = "full_day")
    private Boolean fullDay;

    @ManyToOne
    @JoinColumn(name = "resource_id", referencedColumnName = "id_resource")
    private Resource resource;

    @ManyToOne
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

    public Boolean getFullDay() {
        return fullDay;
    }

    public void setFullDay(Boolean fullDay) {
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
