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
        @NamedQuery(name = Exclusion.ALL_NQUERY,
                query = "select t from Exclusion t"),
        @NamedQuery(name = Exclusion.ID_NQUERY,
                query = "select t from Exclusion t where t.idExclusion = :id")
})
@Entity
public class Exclusion {

    public static final String ALL_NQUERY = "ex.all";
    public static final String ID_NQUERY = "ex.id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exclusion")
    private Integer idExclusion;

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
