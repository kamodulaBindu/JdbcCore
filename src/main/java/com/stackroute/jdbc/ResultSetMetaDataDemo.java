package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetaDataDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public ResultSetMetaDataDemo() throws SQLException {
        //*use driverManager to get Connection*//*
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Example", "root", "root");

        statement = connection.createStatement();
    }



    public void getRowSetMetadata() throws SQLException {
        resultSet= statement.executeQuery("select *from Employee");

        System.out.println("ColumnCount: "+resultSet.getMetaData().getColumnCount());
        System.out.println("FirstColumnName: "+resultSet.getMetaData().getColumnName(1));
        System.out.println("FirstColumnType: "+resultSet.getMetaData().getColumnTypeName(1));
        System.out.println("SecondColumnName: "+resultSet.getMetaData().getColumnName(2));
        System.out.println("SecondColumnType: "+resultSet.getMetaData().getColumnTypeName(2));
        System.out.println("ThirdColumnName: "+resultSet.getMetaData().getColumnName(3));
        System.out.println("ThirdColumntype: "+resultSet.getMetaData().getColumnTypeName(3));
        System.out.println("FourthColumnName: "+resultSet.getMetaData().getColumnName(4));
        System.out.println("FourthColumnType: "+resultSet.getMetaData().getColumnTypeName(4));

    }
    }




