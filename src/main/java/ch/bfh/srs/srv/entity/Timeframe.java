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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Timeframe {
    @Id
    @Column(name = "id_timeframe")
    private Integer idTimeframe;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "start")
    private Timestamp start;

    @Basic
    @Column(name = "end")
    private Timestamp end;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "resourcetimeframe",
            joinColumns =
            @JoinColumn(name = "timeframe_id", referencedColumnName = "id_timeframe"),
            inverseJoinColumns =
            @JoinColumn(name = "resource_id", referencedColumnName = "id_resource")
    )
    private List<Resource> resources;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
