package ch.bfh.srs.srv.service;

import ch.bfh.srs.srv.entity.User;
import org.apache.commons.lang.NotImplementedException;

import java.util.List;

public class UserService extends BaseService {

    public boolean addUser(String surname, String lastname, String password, String mail, Integer role) {
        throw new NotImplementedException();
    }

    public List<User> getUsers(){
        throw new NotImplementedException();
    }

    public User getUser(Integer userId){
        throw new NotImplementedException();
    }

    public boolean confirmUser(Integer userId){
        throw new NotImplementedException();
    }

    public boolean enableUser(Integer userId, boolean enable){
        throw new NotImplementedException();
    }

    public boolean deleteUser(Integer userId){
        throw new NotImplementedException();
    }

    public boolean login(String mail, String password){
        throw new NotImplementedException();
    }

    public boolean register(String surname, String lastname, String password, String mail){
        //Role = Anonymous
        throw new NotImplementedException();
    }
}
