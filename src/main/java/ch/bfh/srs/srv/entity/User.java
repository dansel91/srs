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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(name = "id_user")
    private Integer idUser;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "surname")
    private String surname;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "mail")
    private String mail;

    @OneToMany(mappedBy = "user", targetEntity = Reservation.class,
            fetch = FetchType.EAGER)
    private List<Reservation> reservations;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", referencedColumnName = "id_role")
    private Role role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
