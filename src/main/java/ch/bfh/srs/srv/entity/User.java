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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = User.ALL_NQUERY,
                query = "select t from User t"),
        @NamedQuery(name = User.ID_NQUERY,
                query = "select t from User t where t.idUser = :id")
})
@Entity
@Table(name = "\"user\"")
public class User {
    public static final String ALL_NQUERY = "usr.all";
    public static final String ID_NQUERY = "usr.id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "user", targetEntity = Reservation.class)
    private List<Reservation> reservations;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", referencedColumnName = "id_role")
    private Role role;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

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
