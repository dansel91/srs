package ch.bfh.srs;

import ch.bfh.srs.srv.entity.Reservation;
import ch.bfh.srs.srv.entity.Resource;
import ch.bfh.srs.srv.service.ReservationService;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ReservationServiceTest {

    Connection con = null;
    Statement st = null;
    ReservationService service;

    @Before
    public void setUp(){
        service = new ReservationService();
        try {
            String USERNAME = "";
            String PASSWORD = "";
            String URL = "jdbc:postgresql://localhost/testdb";
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = con.createStatement();
        } catch(SQLException sqlex){
            System.out.print(sqlex.getMessage());
        }
    }

    @Test
    public void testAddReservation(){
        int userId=1;
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);
        boolean fullday = false;
        service.addReservation(userId, start, end, fullday);
        try {
            ResultSet rs = st.executeQuery("SELECT userId, start, end, fullday FROM Reservation WHERE user_id="+userId);
            assertEquals(userId, rs.getInt("user_id"));
            assertEquals(start, DateTime.parse(rs.getString("start")));
            assertEquals(end, DateTime.parse(rs.getString("end")));
            assertEquals(fullday, rs.getBoolean("fullday"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservations();
    }

    @Test
    public void testDeleteReservation() {
        int id = 1;
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);
        try {
            st.executeQuery("INSERT INTO Reservation(id_reservation, resource_id, user_id, from, to, full_day) VALUES("+id+", 1, 1, "+start+","+end+","+ false+")");
            service.deleteReservation(id);
            ResultSet rs = st.executeQuery("SELECT * FROM Reservation WHERE id_reservation="+id);
            assertEquals(false, rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservations();
    }

    @Test
    public void testModReservation() {
        int id = 1;
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);
        try{
            st.executeQuery("INSERT INTO Reservation(id_reservation, resource_id, user_id, from, to, full_day) VALUES("+id+", 1, 1, "+start+","+end+","+ false+")");
            end = start.plusHours(2);
            service.modReservation(id, start, end, false);
            ResultSet rs = st.executeQuery("SELECT end FROM Reservation WHERE id=" + id);
            assertEquals(end, DateTime.parse(rs.getString("end")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservations();
    }

    @Test
    public void testGetReservationsByUserId(){
        int id = 1;
        int resourceId=1;
        int userId = 1;
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);
        try {
            st.executeQuery("INSERT INTO Reservation(id_reservation, resource_id, user_id, from, to, full_day) VALUES("+id+","+resourceId+","+userId+", "+start+","+end+","+ false+")");
            List<Reservation> reservations = service.getReservationsByUserId(userId);
            Reservation res = reservations.get(0);
            assertEquals(start, res.getFrom());
            assertEquals(end, res.getTo());
//            compare other attributes
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservations();
    }

    @Test
    public void testGetReservationsByResourceId(){
        int id = 1;
        int userid = 1;
        int resourceId= 1;
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);
        try {
            st.executeQuery("INSERT INTO Reservation(id_reservation, resource_id, user_id, from, to, full_day) VALUES("+id+","+resourceId+","+userid+", "+start+","+end+","+ false+")");
            List<Reservation> reservations = service.getReservationsByResourceId(resourceId);
            Reservation res = reservations.get(0);
            assertEquals(start, res.getFrom());
            assertEquals(end, res.getTo());
//            compare first entry in List with created entry
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservations();
    }

    @Test
    public void testReservationByUserId(){
        int id = 1;
        int userid = 1;
        int resourceId= 1;
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);
        try {
            st.executeQuery("INSERT INTO Reservation(id_reservation, resource_id, user_id, from, to, full_day) VALUES("+id+","+resourceId+","+userid+", "+start+","+end+","+ false+")");
            List<Reservation> reservations = service.getReservationByUserId(userid, start, end);
            Reservation res = reservations.get(0);
            assertEquals(start, res.getFrom());
            assertEquals(end, res.getTo());
//            compare first entry in List with created entry
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservations();
    }

    private void removeReservations(){
        try{
            st.executeQuery("DELETE * FROM Reservation");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


