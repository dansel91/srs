package ch.bfh.srs;

import ch.bfh.srs.srv.entity.Reservation;
import ch.bfh.srs.srv.service.ReservationService;
import org.apache.commons.lang.NotImplementedException;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;
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
    }

    @Test(expected = NotImplementedException.class)
    public void testAddRecurringReservation() {
        boolean performed = service.addRecurringReservation(1, DateTime.now(), DateTime.now(), false, 1, null, null);
        assertEquals(true, performed);
    }


    @Test(expected = NotImplementedException.class)
    public void testDeleteReservation() {
        int resId = 1;
        boolean deleted = service.deleteReservation(resId);
        assertEquals(true, deleted);

        List<Reservation> reservations = service.getReservationsByResourceId(resId);
        assertTrue(reservations.isEmpty());
    }

    @Test(expected = NotImplementedException.class)
    public void testDeleteRecurringReservation() {

        boolean deleted = service.deleteRecurringReservation(1);
        assertTrue(deleted);
    }

    @Test(expected = NotImplementedException.class)
    public void testModReservation() {
        service.modReservation(1, DateTime.now(), DateTime.now(), false);
    }

    @Test(expected = NotImplementedException.class)
    public void testModRecurringReservation() {
        service.modRecurringReservation(1, DateTime.now(), DateTime.now(), false, 1, null, null);
    }

    @Test(expected = NotImplementedException.class)
    public void testGetReservationsByUserId() {
        List<Reservation> results = service.getReservationsByUserId(1);
        assertTrue(results.size() == 1);
    }

    @Test(expected = NotImplementedException.class)
    public void testGetReservationsByUserIdWithRange() {
        List<Reservation> results = service.getReservationByUserId(1, DateTime.now(), DateTime.now());
        assertTrue(results.size() == 1);
    }

    @Test(expected = NotImplementedException.class)
    public void testGetReservationsByResourceId() {
        List<Reservation> results = service.getReservationsByResourceId(1);
        assertTrue(results.size() == 1);
    }

    @Test(expected = NotImplementedException.class)
    public void testAddExclusion() {
        service.addExclusion(1, DateTime.now());
    }

}


