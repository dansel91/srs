package ch.bfh.srs;

import ch.bfh.srs.srv.entity.Resource;
import ch.bfh.srs.srv.service.ReservationService;
import ch.bfh.srs.srv.service.ResourceService;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class ResourceServiceTest {
    private final String USERNAME="";
    private final String PASSWORD="";
    private final String URL = "jdbc:postgresql://localhost/testdb";

    Connection con = null;
    Statement st = null;
    ResourceService service;

    @Before
    public void setUp(){
        service = new ResourceService();
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = con.createStatement();
        } catch(SQLException sqlex){
            System.out.print(sqlex.getMessage());
        }
    }

    @Test
    public void testAddResource(){
        int resourceId = 1;
        int orgId = 1;
        String name = "foo";
        service.addResource(resourceId, name);
        try{
            ResultSet rs = st.executeQuery("SELECT * FROM Resource WHERE id_resource="+resourceId);
//            compare resultset with created entry
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservation();
    }

    @Test
    public void testGetResources(){
        int resourceId = 1;
        int orgId = 1;
        String name = "foo";
        try{
            st.executeQuery("INSERT INTO Resource(id_resource, organisation_id, name) VALUES("+resourceId+","+orgId+","+name+")");
            List<Resource> resources = service.getResources();
//            compare first entry with created entry
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservation();
    }

    @Test
    public void testGetResource(){
        int resourceId = 1;
        int orgId = 1;
        String name = "foo";
        try{
            st.executeQuery("INSERT INTO Resource(id_resource, organisation_id, name) VALUES("+resourceId+","+orgId+","+name+")");
            Resource res = service.getResource(resourceId);
//            compare first entry with created entry
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservation();
    }

    @Test
    public void testDeleteResource(){
        int resourceId = 1;
        int orgId = 1;
        String name = "foo";
        try{
            st.executeQuery("INSERT INTO Resource(id_resource, organisation_id, name) VALUES("+resourceId+","+orgId+","+name+")");
            service.deleteResource(resourceId);
            ResultSet rs = st.executeQuery("SELECT * FROM Resource WHERE id_resource="+resourceId);
//            Check if no entries
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservation();
    }

    @Test
    public void testModResource(){
        int resourceId = 1;
        int orgId = 1;
        String name = "foo";
        String name2 = "foobar";
        try {
            st.executeQuery("INSERT INTO Resource(id_resource, organisation_id, name) VALUES(" + resourceId + "," + orgId + "," + name + ")");
            service.modResource(resourceId, name2);
            ResultSet rs = st.executeQuery("SELECT name FROM Resource WHERE id_resource="+resourceId);
//            Check if name has changed
        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeReservation();
    }

    private void removeReservation(){
        try{
            st.executeQuery("DELETE * FROM Resource");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
