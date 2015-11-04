package ch.bfh.srs.srv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author zinggpa
 */
@Entity
public class Resourcetimeframe {

    @Id
    @Column(name = "resource_id")
    private Integer resourceId;

    @Id
    @Column(name = "timeframe_id")
    private Integer timeframeId;
}
