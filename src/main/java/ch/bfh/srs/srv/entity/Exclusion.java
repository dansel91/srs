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
        @NamedQuery(name = "ex.all",
                query = "select t from Exclusion t")
})
@Entity
public class Exclusion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exclusion")
    private Integer idRecursion;

    @Basic
    @Column(name = "date")
    private Timestamp date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "recursion_id", referencedColumnName = "id_recursion")
    private Recursion recursion;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Recursion getRecursion() {
        return recursion;
    }

    public void setRecursion(Recursion recursion) {
        this.recursion = recursion;
    }
}