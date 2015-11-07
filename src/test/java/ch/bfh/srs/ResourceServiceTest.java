package ch.bfh.srs;

import ch.bfh.srs.srv.entity.Resource;
import ch.bfh.srs.srv.service.ResourceService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ResourceServiceTest {

    Connection con = null;
    Statement st = null;
    ResourceService service;

    @Before
    public void setUp(){
        service = new ResourceService();
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
    public void testAddResource(){
        int resourceId = 1;
        String name = "foo";
        service.addResource(resourceId, name);
        try{
            ResultSet rs = st.executeQuery("SELECT * FROM Resource WHERE id_resource="+resourceId);
            assertEquals(resourceId, rs.getInt("id_resource"));
            assertEquals(name, rs.getString("name"));
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
            Resource rs = resources.get(0);
            assertEquals(name, rs.getName());
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
            Resource rs = service.getResource(resourceId);
            assertEquals(name, rs.getName());
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
            assertEquals(false, rs.next());
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
            assertEquals(name2, rs.getString("name"));
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
