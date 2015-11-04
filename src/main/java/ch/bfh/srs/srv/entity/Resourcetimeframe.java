/*
 * Copyright (c) 2015 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.srs.srv.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resourcetimeframe {

    @Id
    @Column(name = "resource_id")
    private Integer resourceId;

    @Id
    @Column(name = "timeframe_id")
    private Integer timeframeId;
}
