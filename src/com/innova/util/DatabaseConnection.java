package com.innova.util;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection extends DatabaseInformation{

    private Connection connection;
    private  String url=this.getUrl();
    private  String username=this.getUserName();
    private  String password=this.getUserPassword();

    //Singleton Design Pattern
    private static DatabaseConnection instance;

    public DatabaseConnection() {
        //super();

        try {
            Class.forName(this.getForNameData());
            System.out.println("Driver Success");
            this.connection= DriverManager.getConnection(url,username,userPassword);
            System.out.println("Connection Success ...");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }

    public static DatabaseConnection getInstance() {
        try {
            if(instance==null)
                instance=new DatabaseConnection();
            else if(instance.connection.isClosed())
                instance=new DatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        DatabaseConnection databaseConnection=new DatabaseConnection();
    }
}
