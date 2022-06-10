package com.objectpoolpattern;

import java.sql.Connection;

public class TestObjectPool {

    public static void main(String[] args) {
       // Create the ConnectionPool:
       JDBCConnectionPool pool = new JDBCConnectionPool(
       "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/mydb",
       "root", "root");
 
        // Get a connection:
        Connection connection = pool.getObject();
 
       // Use the connection

       // Return the connection:object back to the pool
       pool.releaseObject(connection);
	}
}
