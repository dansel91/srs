package ch.bfh.srs;

import ch.bfh.srs.srv.entity.User;
import ch.bfh.srs.srv.service.UserService;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class UserServiceTest {
    private final String USERNAME="";
    private final String PASSWORD="";
    private final String URL = "jdbc:postgresql://localhost/testdb";

    Connection con = null;
    Statement st = null;
    UserService service;

    @Before
    public void setUp() {
        service = new UserService();
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = con.createStatement();
        } catch(SQLException sqlex){
            System.out.print(sqlex.getMessage());
        }
    }

    @Test
    public void testAddUser(){
        String surname = "Max";
        String lastname = "Muster";
        String passwort = "1234";
        String mail = "max@muster.ch";
        int role = 1;
        service.addUser(surname, lastname, passwort, mail, role);
        try{
            ResultSet rs = st.executeQuery("SELECT * FROM USER");
        }catch (SQLException e) {
                e.printStackTrace();
        }

    }

    @Test
    public void testGetUsers() {
        String surname = "Max";
        String lastname = "Muster";
        String passwort = "1234";
        String mail = "max@muster.ch";
        int role = 1;
        try{
            st.executeQuery("INSERT USER(surname, lastname, passwort, mail, role) VALUES ("+surname+","+lastname+","+passwort+","+mail+","+role+")");
            List<User> users = service.getUsers();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
