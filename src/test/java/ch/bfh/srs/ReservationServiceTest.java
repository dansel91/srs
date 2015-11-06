package ch.bfh.srs;

import ch.bfh.srs.srv.entity.Reservation;
import ch.bfh.srs.srv.service.ReservationService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.List;

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
        service.addReservation(userId, start, end, false);
        try {
            ResultSet rs = st.executeQuery("SELECT userId, start, end, fullday FROM Reservation WHERE user_id="+userId);
//          compare rs with the given data
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
//          compare of the query contains zero statements
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
            st.executeQuery("SELECT end FROM Reservation WHERE id="+id);
//            compare result endtime with given endtime
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
            List<Reservation> res = service.getReservationsByUserId(userId);
//            compare first entry in List with created entry
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
            List<Reservation> res = service.getReservationsByResourceId(resourceId);
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
            List<Reservation> res = service.getReservationByUserId(userid, start, end);
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


