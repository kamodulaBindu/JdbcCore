package com.stackroute.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class RowSetDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public RowSetDemo() throws SQLException {



    }

    public void getRowSetDetails() throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver");


        //Creating and Executing RowSet
        JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
        rowSet.setUrl("jdbc:mysql://localhost:3306/Example");
        rowSet.setUsername("root");
        rowSet.setPassword("root");
        rowSet.setCommand("select * from Employee");
        rowSet.execute();

        while (rowSet.next()) {

            System.out.println("id: " + rowSet.getInt(1) + "   name: " + rowSet.getString(2) + "id: " + rowSet.getInt(3) + "   name: " + rowSet.getString(4));
        }
    }


}