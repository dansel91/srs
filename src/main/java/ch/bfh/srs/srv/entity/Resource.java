package ch.bfh.srs.srv.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author zinggpa
 */
@Entity
public class Resource {

    @Id
    @Column(name = "id_resource")
    private Integer idResource;

    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id_organisation")
    private Organisation organisation;

    @OneToMany(mappedBy = "resource", targetEntity = Reservation.class,
            fetch = FetchType.EAGER)
    private List<Reservation> reservations;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "resourcetimeframe",
            joinColumns =
            @JoinColumn(name = "resource_id", referencedColumnName = "id_resource"),
            inverseJoinColumns =
            @JoinColumn(name = "timeframe_id", referencedColumnName = "id_timeframe")
    )
    private List<Timeframe> timeframes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Timeframe> getTimeframes() {
        return timeframes;
    }

    public void setTimeframes(List<Timeframe> timeframes) {
        this.timeframes = timeframes;
    }
}
