package ch.bfh.srs;

import ch.bfh.srs.srv.entity.User;
import ch.bfh.srs.srv.service.UserService;
import org.apache.commons.lang.NotImplementedException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {

    UserService service;

    @Before
    public void setUp() {
        service = new UserService();
    }

    @Test(expected = NotImplementedException.class)
    public void testAddUser() {
        boolean added = service.addUser("Hans", "Mustermann", "asdf", "hans@muster.ch", 1);
    }

    @Test(expected = NotImplementedException.class)
    public void testGetUsers() {
        List<User> users = service.getUsers();
    }

    @Test(expected = NotImplementedException.class)
    public void testGetUser() {
        User user = service.getUser(1);
    }

    @Test(expected = NotImplementedException.class)
    public void testConfirmUser() {
        boolean confirmed = service.confirmUser(1);
    }

    @Test(expected = NotImplementedException.class)
    public void testEnableUser() {
        boolean enabled = service.enableUser(1, true);
    }

    @Test(expected = NotImplementedException.class)
    public void testDeleteUser() {
        boolean deleted = service.deleteUser(1);
    }

    @Test(expected = NotImplementedException.class)
    public void testLogin() {
        boolean loggedIn = service.login("hans@muster.ch", "asdf");
    }

    @Test(expected = NotImplementedException.class)
    public void testRegister() {
        boolean register = service.register("Max", "Mustermann", "asdf", "max@mutermann.ch");
    }
}
