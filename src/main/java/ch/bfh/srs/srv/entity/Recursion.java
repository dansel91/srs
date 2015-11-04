package ch.bfh.srs.srv.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @author zinggpa
 */
@Entity
public class Recursion {

    @Id
    @Column(name = "id_recursion")
    private Integer idRecursion;

    @Basic
    @Column(name = "day")
    private Integer day;

    @Basic
    @Column(name = "week")
    private Integer week;

    @Basic
    @Column(name = "month")
    private Integer month;

    @OneToOne(optional = false)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @OneToMany(mappedBy = "recursion", targetEntity = Exclusion.class,
            fetch = FetchType.EAGER)
    private List<Exclusion> exclusions;

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public List<Exclusion> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List<Exclusion> exclusions) {
        this.exclusions = exclusions;
    }
}
