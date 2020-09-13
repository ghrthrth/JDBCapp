package com.app.com;

import java.util.Scanner;
public class TestDatabase {
    static String URL;
    static String USER;
    static String PASS;
    public static void main(String[] args) {
        Database db = new Database();
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("writing USER: ");
            USER = in.nextLine();
            System.out.println("writing PASS: ");
            PASS = in.nextLine();
            System.out.println("written URL: ");
            URL = in.nextLine();
            db.connect(URL,PASS,USER);
            DBWorker.createStatement(db.con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
    }
}