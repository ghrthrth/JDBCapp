package com.app.com;


import java.sql.*;
import java.util.Scanner;

public class work {

    static String USER;
    static String PASS;
    static String DB_URL;
    static String DATA;
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Database user name: ");
        USER = in.nextLine();
        System.out.print("Database password: ");
        PASS = in.nextLine();
        System.out.print("DB URL: ");
        DB_URL = in.nextLine();
        System.out.print("What your mean  at sql?(written please sql-request): ");
        DATA = in.nextLine();
        DB_URL = DB_URL + ";user="+ USER + ";password=" + PASS;
        Connection conn = null;
        Statement stmt;
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            String sql = DATA;
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}