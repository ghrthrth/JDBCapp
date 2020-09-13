package com.app.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    public Connection con;

    public void connect(final String URL,final String USER, final String PASS) throws Exception{

        if(con != null) return;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("No database");
        }

        con = DriverManager.getConnection(URL,PASS,USER);
    }

    public void close(){
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
