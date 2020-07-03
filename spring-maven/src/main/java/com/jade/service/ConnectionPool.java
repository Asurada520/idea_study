package com.jade.service;

import java.sql.Connection;

// database connection pool
public interface ConnectionPool {

    // get connection
    public Connection getConnection();

    // release connection
    public void releaseConnection(Connection connection);

}
