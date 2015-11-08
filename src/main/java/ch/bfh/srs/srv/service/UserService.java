/*
 * Copyright (c) 2015 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
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

    public User getUser(int userId){
        throw new NotImplementedException();
    }

    public boolean confirmUser(int userId){
        throw new NotImplementedException();
    }

    public boolean enableUser(int userId, boolean enable){
        throw new NotImplementedException();
    }

    public boolean deleteUser(int userId){
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
