package ch.bfh.srs;

import ch.bfh.srs.srv.entity.User;
import ch.bfh.srs.srv.service.UserService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class UserServiceTest {

    Connection con = null;
    Statement st = null;
    UserService service;

    @Before
    public void setUp() {
        service = new UserService();
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
    public void testAddUser() {
        String surname = "Max";
        String lastname = "Muster";
        String password = "1234";
        String mail = "max@muster.ch";
        int role = 1;
        service.addUser(surname, lastname, password, mail, role);
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM USER");
            assertEquals(surname, rs.getString("surname"));
            assertEquals(lastname, rs.getString("lastname"));
            assertEquals(password, rs.getString("password"));
            assertEquals(mail, rs.getString("mail"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetUsers() {
        String surname = "Max";
        String lastname = "Muster";
        String password = "1234";
        String mail = "max@muster.ch";
        int role = 1;
        try {
            st.executeQuery("INSERT USER(surname, lastname, password, mail, role_id) VALUES (" + surname + "," + lastname + "," + password + "," + mail + "," + role + ")");
            List<User> users = service.getUsers();
            User user = users.get(0);
            assertEquals(surname, user.getSurname());
            assertEquals(lastname, user.getLastname());
            assertEquals(password, user.getPassword());
            assertEquals(mail, user.getMail());
            ResultSet rs = st.executeQuery("SELECT name FROM role WHERE role_id=" + role);
            assertEquals(rs.getString("name"), user.getRole().getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
