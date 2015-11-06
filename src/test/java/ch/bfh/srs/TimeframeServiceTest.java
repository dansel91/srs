package ch.bfh.srs;

import ch.bfh.srs.srv.service.TimeframeService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class TimeframeServiceTest {
    private final String USERNAME = "";
    private final String PASSWORD = "";
    private final String URL = "jdbc:postgresql://localhost/testdb";

    Connection con = null;
    Statement st = null;
    TimeframeService service;

    @Before
    public void setUp() {
        service = new TimeframeService();
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = con.createStatement();
        } catch (SQLException sqlex) {
            System.out.print(sqlex.getMessage());
        }
    }

    @Test
    public void testAddTimeframe() {
        int id_timeframe = 1;
        int resourceid = 1;
        String name = "foo";
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);

        try {
            service.addTimeframe(resourceid, name, start, end);
            ResultSet rs = st.executeQuery("SELECT * FROM Timeframe WHERE id_timeframe=" + id_timeframe);
//            compare resultset with created entry
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeTimeframe();
    }

    @Test
    public void testModTimeframe() {
        int id_timeframe = 1;
        int resourceid = 1;
        String name = "foo";
        String name2 = "foobar";
        DateTime start = DateTime.now();
        DateTime end = start.plusHours(1);
        DateTime end2 = start.plusHours(2);

        try {
            st.executeQuery("INSERT INTO Timeframe(id_timeframe, name, start, end) VALUES(" + id_timeframe + "," + name + "," + start + "," + end + ")");
            service.modTimeframe(id_timeframe, name2, start, end2);
            ResultSet rs = st.executeQuery("SELECT * FROM Timeframe WHERE id_timeframe=" + id_timeframe);
//          Check if values have changed
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
//          Check if no entries there
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
