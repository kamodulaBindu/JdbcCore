package com.stackroute.jdbc;

import java.sql.*;
public class DatabaseMetaDataDemo  {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private static final String URL = "jdbc:mysql://localhost:3306/Example";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public DatabaseMetaDataDemo() throws Exception {
        //*use driverManager to get Connection*//*
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Example", "root", "root");

        statement = connection.createStatement();


    }


    public void getDataBaseDetails() throws SQLException {
        System.out.println("URL: "+connection.getMetaData().getURL());
        System.out.println("UserName: "+connection.getMetaData().getUserName());
        System.out.println("DriverName: "+connection.getMetaData().getDriverName());
        System.out.println("DriverVersion: "+connection.getMetaData().getDriverVersion());
        System.out.println("DatabaseProductName: "+connection.getMetaData().getDatabaseProductName());
        System.out.println("DataBaseProductVersion: "+connection.getMetaData().getDatabaseProductVersion());
    }
}
