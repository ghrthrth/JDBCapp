package com.app.com;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBWorker {
    public DBWorker(){
    }

    public static void createStatement(final Connection connection) throws SQLException{
        final String quitWord = "quit";
        StringBuilder query = new StringBuilder();
        System.out.println("Create statement");
        Statement statement = connection.createStatement();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter query: ");
        while (statement != null) {
            try{
                query.append(in.nextLine());

                if (query.toString().equals(quitWord)){
                    System.out.println("Close program");
                    statement.close();
                    break;
                }
                if (query.charAt(query.length() - 1) == ';'){
                    query = new StringBuilder();
                    System.out.println("Success! Enter next query or type 'quit' to stop the program");
                }
            } catch (SQLException e) {
                System.out.println("Execute error! Check the syntax!");
            }
        }
        in.close();
    }
}