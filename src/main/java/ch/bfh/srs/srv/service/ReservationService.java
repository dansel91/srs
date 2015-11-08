/*
 * Copyright (c) 2015 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.srs.srv.service;

import ch.bfh.srs.srv.entity.Reservation;
import org.apache.commons.lang.NotImplementedException;
import org.joda.time.DateTime;

import java.util.List;

public class ReservationService extends BaseService<Reservation> {

    public boolean addReservation(int userId, DateTime start, DateTime end, boolean fullday) {
        throw new NotImplementedException();
    }

    public boolean addRecurringReservation(int userId, DateTime start, DateTime end, boolean fullday, Integer day, Integer week, Integer month) {
        throw new NotImplementedException();
    }

    public boolean deleteReservation(int reservationId) {
        throw new NotImplementedException();
    }

    public boolean deleteRecurringReservation(int reservationId) {
        throw new NotImplementedException();
    }

    public boolean addExclusion(int reservationId, DateTime date) {
        throw new NotImplementedException();
    }

    public boolean modRecurringReservation(int reservationId, DateTime start, DateTime end, boolean fullday, Integer day, Integer week, Integer month) {
        throw new NotImplementedException();
    }

    public boolean modReservation(int reservationId, DateTime start, DateTime end, boolean fullday) {
        throw new NotImplementedException();
    }

    public List<Reservation> getReservationsByResourceId(int resourceId) {
        throw new NotImplementedException();
    }

    public List<Reservation> getReservationsByUserId(int userId) {
        throw new NotImplementedException();
    }

    public List<Reservation> getReservationByUserId(int userId, DateTime from, DateTime to) {
        throw new NotImplementedException();
    }
}
