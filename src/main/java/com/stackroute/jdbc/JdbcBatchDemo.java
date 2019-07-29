package com.stackroute.jdbc;

import java.sql.*;
import java.util.Arrays;

public class JdbcBatchDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public JdbcBatchDemo() throws Exception {
        //*use driverManager to get Connection*//*
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Example", "root", "root");

        statement = connection.createStatement();

    }

    public void addBatch() {


        try {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Employee SET empAge=? WHERE empName=?;")) {
                preparedStatement.setInt(1, 16);
                preparedStatement.setString(2, "Bindu");
                preparedStatement.addBatch();

                preparedStatement.setInt(1, 20);
                preparedStatement.setString(2, "Teju");

                preparedStatement.addBatch();



                int[] arr = preparedStatement.executeBatch();

                connection.commit();

                resultSet= statement.executeQuery("select *from Employee");


                while (resultSet.next()){
                    System.out.println("id: "+resultSet.getInt(1)+"   name: "+resultSet.getString(2)+"id: "+resultSet.getInt(3)+"   name: "+resultSet.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                connection.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}