package com.jade.service.impl;

import com.jade.config.DBConfig;
import com.jade.service.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ConnectionPoolImpl implements ConnectionPool {

    private DBConfig dbConfig;

    // 空闲连接
    private List<Connection> freeConnection = new Vector<Connection>();

    // 活动连接
    private List<Connection> activeConnection = new Vector<Connection>();

    private int count = 0;

    public ConnectionPoolImpl(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
        init();
    }

    public void init() {
        if (dbConfig == null) {
            return;
        }
        for (int i = 0; i < dbConfig.getInitConnections(); i++) {
            Connection connection = createConnection();
            freeConnection.add(connection);
        }

    }

    public synchronized Connection createConnection() {

        try {

            Class.forName(dbConfig.getDriverName());
            Connection connection = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUserName(), dbConfig.getPassword());
            count++;

            return connection;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public synchronized Connection getConnection() {
        Connection connection = null;

        // 当前连接数 是否超过最大连接数
        if (count < dbConfig.getMaxActiveConnections()) {

            if (freeConnection.size() > 0) {
                connection = freeConnection.remove(0);
            } else {
                connection = createConnection();
            }


            if (isAvailable(connection)) {
                activeConnection.add(connection);
            } else {
                count--;
                connection = getConnection();
            }

        } else {

            try {
                wait(dbConfig.getConnTimeOut());
                connection = getConnection();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }

        }

        return connection;
    }

    public boolean isAvailable(Connection connection) {

        try {
            if (connection == null || connection.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    @Override
    public synchronized void releaseConnection(Connection connection) {


        try {
            if (isAvailable(connection)) {

                if (freeConnection.size() < dbConfig.getMaxConnections()) {
                    freeConnection.add(connection);
                } else {
                    connection.close();
                }
                activeConnection.remove(connection);

                count--;

                notifyAll();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
