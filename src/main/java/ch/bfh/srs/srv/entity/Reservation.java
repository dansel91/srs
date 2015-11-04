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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

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
