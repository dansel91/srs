package ch.bfh.srs.srv.service;

import ch.bfh.srs.srv.entity.Reservation;
import org.apache.commons.lang.NotImplementedException;
import org.joda.time.DateTime;

import java.util.List;

public class ReservationService extends BaseService{

    public boolean addReservation(Integer userId, DateTime start, DateTime end, boolean fullday){
        throw new NotImplementedException();
    }

    public boolean addRecurringReservation(Integer userId, DateTime start, DateTime end, boolean fullday, Integer day, Integer week, Integer month){
        throw new NotImplementedException();
    }

    public boolean deleteReservation(Integer reservationId){
        throw new NotImplementedException();
    }

    public boolean deleteRecurringReservation(Integer reservationId){
        throw new NotImplementedException();
    }

    public boolean addExclusion(Integer reservationId, DateTime date){
        throw new NotImplementedException();
    }

    public boolean modRecurringReservation(Integer reservationId, DateTime start, DateTime end, boolean fullday, Integer day, Integer week, Integer month){
        throw new NotImplementedException();
    }

    public boolean modReservation(Integer reservationId, DateTime start, DateTime end, boolean fullday){
        throw new NotImplementedException();
    }

    public List<Reservation> getReservationsbyResourceId(Integer resourceId){
        throw new NotImplementedException();
    }

    public List<Reservation> getReservationsbyUserId(Integer userId){
        throw new NotImplementedException();
    }

    public List<Reservation> getReservationbyUserId(Integer userId, DateTime from, DateTime to){
        throw new NotImplementedException();
    }
}
