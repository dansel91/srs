package ch.bfh.srs;

import ch.bfh.srs.srv.entity.User;
import ch.bfh.srs.srv.service.UserService;
import org.apache.commons.lang.NotImplementedException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserServiceTest {

    UserService service;

    @Before
    public void setUp() {
        service = new UserService();
    }

    @Test(expected = NotImplementedException.class)
    public void testAddUser() {
        boolean added = service.addUser("Hans", "Mustermann", "asdf", "hans@muster.ch", 1);
        User userEntity = service.getById(User.ID_NQUERY, 1);
        assertNotNull(userEntity);
        assertEquals("Hans", userEntity.getSurname());
        assertEquals("Mustermann", userEntity.getLastname());
        assertEquals("asdf", userEntity.getPassword());
        assertEquals("hans@muster.ch", userEntity.getMail());
    }

    @Test(expected = NotImplementedException.class)
    public void testGetUsers() {
        List<User> users = service.getUsers();
        assertEquals(1, users.size());
        assertEquals("hans@muster.ch", users.get(0).getMail());
    }

    @Test(expected = NotImplementedException.class)
    public void testGetUser()
    {
        User user = service.getUser(1);
        assertEquals(1, (int) user.getIdUser());
        assertEquals("hans@muster.ch", user.getMail());
    }

    @Test(expected = NotImplementedException.class)
    public void testConfirmUser() {
        boolean confirmed = service.confirmUser(1);
        assertEquals(true, confirmed);
    }

    @Test(expected = NotImplementedException.class)
    public void testEnableUser() {
        boolean enabled = service.enableUser(1, true);
        assertEquals(true, enabled);
    }

    @Test(expected = NotImplementedException.class)
    public void testDeleteUser() {
        boolean deleted = service.deleteUser(1);
        User userEntity = service.getById(User.ID_NQUERY, 1);
        assertNull(userEntity);
    }

    @Test(expected = NotImplementedException.class)
    public void testLogin() {

        boolean loggedIn = service.login("hans@muster.ch", "asdf");
        assertEquals(true, loggedIn);
    }

    @Test(expected = NotImplementedException.class)
    public void testRegister() {
        boolean register = service.register("Max", "Mustermann", "asdf", "max@mustermann.ch");
        User userEntity = service.getById(User.ID_NQUERY, 2);
        assertEquals(2, (int) userEntity.getIdUser());
        assertEquals("max@mustermann.ch", userEntity.getMail());
        assertEquals("Max", userEntity.getSurname());
        assertEquals("Mustermann", userEntity.getLastname());
        assertEquals("asdf", userEntity.getPassword());
    }
}
