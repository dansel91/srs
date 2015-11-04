package ch.bfh.srs.srv.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author zinggpa
 */
@Entity
public class Exclusion {

    @Id
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
