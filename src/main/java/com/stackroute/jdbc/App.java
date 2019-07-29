package com.stackroute.jdbc;

import javax.sql.RowSetMetaData;
import java.sql.DatabaseMetaData;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        SimpleJdbcDemo simpleJdbcDemo =new SimpleJdbcDemo();
        simpleJdbcDemo.getEmployeeDetails();
        System.out.println(" \n");
        simpleJdbcDemo.getEmployeeDetailsInReverse();
        System.out.println(" \n");
        simpleJdbcDemo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println(" \n");
        simpleJdbcDemo.getEmployeeDetailsByNameAndGender("Bindu","Female");
        System.out.println(" \n");
        DatabaseMetaDataDemo databaseMetaDataDemo = new DatabaseMetaDataDemo();
        databaseMetaDataDemo.getDataBaseDetails();
        System.out.println(" \n");
        JdbcBatchDemo jdbcBatchDemo= new JdbcBatchDemo();
        jdbcBatchDemo.addBatch();
        System.out.println(" \n");
        ResultSetMetaDataDemo resultSetMetaDataDemo = new ResultSetMetaDataDemo();
        resultSetMetaDataDemo.getRowSetMetadata();
        System.out.println(" \n");
        RowSetDemo rowSetDemo = new RowSetDemo();
        rowSetDemo.getRowSetDetails();
        System.out.println(" \n");
        JdbcTransactionDemo jdbcTransactionDemo = new JdbcTransactionDemo();
        jdbcTransactionDemo.saveOrder();
    }
}
