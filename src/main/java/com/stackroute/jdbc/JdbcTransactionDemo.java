package com.stackroute.jdbc;

import java.sql.*;

public class JdbcTransactionDemo {
   private static final String db_driver = "com.mysql.cj.jdbc.Driver";
   private static final String url = "jdbc:mysql://localhost:3306/Example";
   private static final String db_User="root";
   private static final String db_Password="root";


    public void saveOrder() throws SQLException, ClassNotFoundException{
        Class.forName(db_driver);
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, db_User, db_Password);

            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement("Insert into Employee values(?,?,?,?)");


            preparedStatement.setInt(1, 6);
            preparedStatement.setString(2, "Bunny");
            preparedStatement.setInt(3, 25);

            preparedStatement.setString(3, "Male");

            preparedStatement.executeUpdate();

            connection.commit();

        } catch (SQLException ex) {
            if (connection != null) {
                try {

                    connection.rollback();

                    System.out.println("Rolled back.");
                } catch (SQLException exrb) {
                    exrb.printStackTrace();
                }
            }
        }
        finally {
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }
    }
}
