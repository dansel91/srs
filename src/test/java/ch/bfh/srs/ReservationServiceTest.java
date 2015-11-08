package ch.bfh.srs;

import ch.bfh.srs.srv.entity.Exclusion;
import ch.bfh.srs.srv.entity.Reservation;
import ch.bfh.srs.srv.service.ReservationService;
import org.apache.commons.lang.NotImplementedException;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;

import static junit.framework.Assert.*;
import static junit.framework.TestCase.assertEquals;

public class ReservationServiceTest {

    ReservationService service;

    @Before
    public void setUp() {
        service = new ReservationService();
    }

    @Test(expected = NotImplementedException.class)
    public void testAddReservation() {
        boolean performed = service.addReservation(1, DateTime.now(), DateTime.now(), false);
        assertEquals(true, performed);
        Reservation reservationEntity = service.getById(Reservation.ID_NQUERY, 1);
        assertNotNull(reservationEntity);
    }

    @Test(expected = NotImplementedException.class)
    public void testAddRecurringReservation() {
        DateTime from = DateTime.now();
        DateTime to = DateTime.now().plus(Period.hours(2));
        boolean performed = service.addRecurringReservation(1, from, to, false, 1, null, null);
        assertEquals(true, performed);
        Reservation reservationEntity = service.getById(Reservation.ID_NQUERY, 1);
        assertNotNull(reservationEntity);
        assertEquals(new Timestamp(from.getMillis()), reservationEntity.getFrom());
        assertEquals(new Timestamp(to.getMillis()), reservationEntity.getTo());
        assertFalse(reservationEntity.getFullDay());
        //TODO: Recurring field assertion (no entity object so far)
    }


    @Test(expected = NotImplementedException.class)
    public void testDeleteReservation() {
        int resId = 1;
        boolean deleted = service.deleteReservation(resId);
        assertEquals(true, deleted);

        List<Reservation> reservations = service.getReservationsByResourceId(resId);
        assertTrue(reservations.isEmpty());
        Reservation reservationEntity = service.getById(Reservation.ID_NQUERY, resId);
        assertNull(reservationEntity);
    }

    @Test(expected = NotImplementedException.class)
    public void testDeleteRecurringReservation() {
        boolean deleted = service.deleteRecurringReservation(1);
        assertTrue(deleted);
        Reservation reservationEntity = service.getById(Reservation.ID_NQUERY, 1);
        assertNull(reservationEntity);
    }

    @Test(expected = NotImplementedException.class)
    public void testModReservation() {
        DateTime from = DateTime.now();
        DateTime to = DateTime.now().plus(Period.hours(4));
        boolean modified = service.modReservation(1, from, to, false);
        assertTrue(modified);
        Reservation reservationEntity = service.getById(Reservation.ID_NQUERY, 1);
        assertNotNull(reservationEntity);
        assertEquals(new Timestamp(from.getMillis()), reservationEntity.getFrom());
        assertEquals(new Timestamp(to.getMillis()), reservationEntity.getTo());
        assertFalse(reservationEntity.getFullDay());
    }

    @Test(expected = NotImplementedException.class)
    public void testModRecurringReservation() {
        DateTime from = DateTime.now();
        DateTime to = DateTime.now().plus(Period.hours(4));
        boolean modified = service.modRecurringReservation(1, from, to, false, 1, null, null);
        assertTrue(modified);
        Reservation reservationEntity = service.getById(Reservation.ID_NQUERY, 1);
        assertNotNull(reservationEntity);
        assertEquals(new Timestamp(from.getMillis()), reservationEntity.getFrom());
        assertEquals(new Timestamp(to.getMillis()), reservationEntity.getTo());
        assertFalse(reservationEntity.getFullDay());
    }

    @Test(expected = NotImplementedException.class)
    public void testGetReservationsByUserId() {
        List<Reservation> results = service.getReservationsByUserId(1);
        assertTrue(results.size() == 1);
        Reservation reservationEntity = service.getById(Reservation.ID_NQUERY, 1);
        assertEquals(reservationEntity, results.get(0));
    }

    @Test(expected = NotImplementedException.class)
    public void testGetReservationsByUserIdWithRange() {
        DateTime from = DateTime.now().minus(Period.days(10));
        DateTime to = DateTime.now();
        List<Reservation> results = service.getReservationByUserId(1, from, to);
        assertTrue(results.size() == 1);
        Reservation reservationEntity = service.getById(Reservation.ID_NQUERY, 1);
        assertEquals(reservationEntity, results.get(0));
    }

    @Test(expected = NotImplementedException.class)
    public void testGetReservationsByResourceId() {
        List<Reservation> results = service.getReservationsByResourceId(1);
        assertTrue(results.size() == 1);
        Reservation reservationEntity = service.getById(Reservation.ID_NQUERY, 1);
        assertEquals(reservationEntity, results.get(0));
    }

    @Test(expected = NotImplementedException.class)
    public void testAddExclusion() {
        boolean added = service.addExclusion(1, DateTime.now());
        assertTrue(added);
        EntityManager em = service.getEntityManager();
        Exclusion exclusion = em.createNamedQuery(Exclusion.ID_NQUERY, Exclusion.class).setParameter("id", 1).getSingleResult();
        assertNotNull(exclusion);
    }
}


