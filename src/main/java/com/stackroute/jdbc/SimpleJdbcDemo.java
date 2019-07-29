package com.stackroute.jdbc;

import java.sql.*;

public class SimpleJdbcDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;



    public SimpleJdbcDemo() throws Exception {
        //*use driverManager to get Connection*//*
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Example","root","root");

        statement = connection.createStatement();

    }

    public void getEmployeeDetails(){


        try {
            //*load Driver and register with DriverManager*//*
            Class.forName("com.mysql.cj.jdbc.Driver");


             resultSet= statement.executeQuery("select *from Employee");


            while (resultSet.next()){
                System.out.println("id: "+resultSet.getInt(1)+"   name: "+resultSet.getString(2));
            }

        } catch ( SQLException e) {
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
            //

        }

    }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {

        try {
            //*load Driver and register with DriverManager*//*
            Class.forName("com.mysql.cj.jdbc.Driver");


            resultSet= statement.executeQuery("select *from Employee;");
            resultSet.afterLast();
            while (resultSet.previous()){
                System.out.println("Gender: "+resultSet.getString(4)+"   Age: "+resultSet.getInt(3)+"   Name: "+resultSet.getString(2)+"  Id: "+resultSet.getInt(1));
            }

        } catch ( SQLException e) {
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
            //

        }

    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            //*load Driver and register with DriverManager*//*
            Class.forName("com.mysql.cj.jdbc.Driver");


            resultSet= statement.executeQuery("select *from Employee;");
            resultSet.absolute(-2);
            while (resultSet.previous()){
                System.out.println("Gender: "+resultSet.getString(4)+"   Age: "+resultSet.getInt(3)+"   Name: "+resultSet.getString(2)+"  Id: "+resultSet.getInt(1));
            }

        } catch ( SQLException e) {
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
            //

        }


    }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,String gender) throws SQLException {

        try {
            //*load Driver and register with DriverManager*//*
            Class.forName("com.mysql.cj.jdbc.Driver");

           /* PreparedStatement stmt=connection.prepareStatement("select *from Employee where empName=?,empGender=?");
            stmt.setString(1,name);
            stmt.setString(2,gender);*/


            PreparedStatement pst;
            pst = connection.prepareStatement("select *from Employee where empName=? and empGender=?");
            pst.setString(1, name);
            pst.setString(2, gender);
            ResultSet resultSet = pst.executeQuery();


            while (resultSet.next()) {
                System.out.println("Gender: " + resultSet.getString(4) + "   Age: " + resultSet.getInt(3) + "   Name: " + resultSet.getString(2) + "  Id: " + resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
            //

        }





    }
}
