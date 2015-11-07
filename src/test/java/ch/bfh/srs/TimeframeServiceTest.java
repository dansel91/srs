package ch.bfh.srs;

import ch.bfh.srs.srv.service.TimeframeService;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static junit.framework.TestCase.assertEquals;

public class TimeframeServiceTest {

    Connection con = null;
    Statement st = null;
    TimeframeService service;

    @Before
    public void setUp() {
        service = new TimeframeService();
        try {
            String USERNAME = "";
            String PASSWORD = "";
            String URL = "jdbc:postgresql://localhost/testdb";
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = con.createStatement();
        } catch (SQLException sqlex) {
            System.out.print(sqlex.getMessage());
        }
    }

    @Test
    public void testAddTimeframe() {
        int id_timeframe = 1;
        String name = "foo";
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);

        try {
            service.addTimeframe(id_timeframe, name, start, end);
            ResultSet rs = st.executeQuery("SELECT * FROM Timeframe WHERE id_timeframe=" + id_timeframe);
            assertEquals(id_timeframe, rs.getInt("id_timeframe"));
            assertEquals(name, rs.getString("name"));
            assertEquals(start, DateTime.parse(rs.getString("start")));
            assertEquals(end, DateTime.parse(rs.getString("end")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeTimeframe();
    }

    @Test
    public void testModTimeframe() {
        int id_timeframe = 1;
        String name = "foo";
        String name2 = "foobar";
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);
        DateTime end2 = start.plusHours(2);

        try {
            st.executeQuery("INSERT INTO Timeframe(id_timeframe, name, start, end) VALUES(" + id_timeframe + "," + name + "," + start + "," + end + ")");
            service.modTimeframe(id_timeframe, name2, start, end2);
            ResultSet rs = st.executeQuery("SELECT * FROM Timeframe WHERE id_timeframe=" + id_timeframe);
            assertEquals(id_timeframe, rs.getInt("id_timeframe"));
            assertEquals(name2, rs.getString("name"));
            assertEquals(start, DateTime.parse(rs.getString("start")));
            assertEquals(end2, DateTime.parse(rs.getString("end")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeTimeframe();
    }

    @Test
    public void testDeleteTimeframe() {
        int id_timeframe = 1;
        String name = "foo";
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);
        try {
            st.executeQuery("INSERT INTO Timeframe(id_timeframe, name, start, end) VALUES(" + id_timeframe + "," + name + "," + start + "," + end + ")");
            service.deleteTimeframe(id_timeframe);
            ResultSet rs = st.executeQuery("SELECT * FROM Timeframe WHERE id_timeframe=" + id_timeframe);
            assertEquals(false, rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeTimeframe(){
        try{
            st.executeQuery("DELETE * FROM Timeframe");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
