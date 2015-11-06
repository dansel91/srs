/*
 * Copyright (c) 2015 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.srs.srv.service;

import java.sql.*;

public class BaseService {

    public static void main(String[] args){
        BaseService bs = new BaseService();
        bs.foo();
    }

    private final String USERNAME="";
    private final String PASSWORD="";
    private final String URL = "jdbc:postgresql://localhost/testdb";

    Connection con = null;
    Statement st = null;

    /**
     * Constructor sets up DB connection
     */
    public BaseService(){
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            st = con.createStatement();
        } catch(SQLException sqlex){
            System.out.print(sqlex.getMessage());
        }
    }

    public void foo() {
        try {
            ResultSet rs = st.executeQuery("SELECT VERSION()");
            if (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }

    }
}
