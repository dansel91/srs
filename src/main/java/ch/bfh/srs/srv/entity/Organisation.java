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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Organisation.ALL_NQUERY,
                query = "select t from Organisation t"),
        @NamedQuery(name = Organisation.ID_NQUERY,
                query = "select t from Organisation t where t.idOrganisation = :id")
})
@Entity
public class Organisation {
    public static final String ALL_NQUERY = "org.all";
    public static final String ID_NQUERY = "org.id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_organisation")
    private Integer idOrganisation;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "organisation", targetEntity = Resource.class)
    private List<Resource> resources;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
