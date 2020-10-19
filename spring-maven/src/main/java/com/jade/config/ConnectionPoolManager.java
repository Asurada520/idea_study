package com.jade.config;

import com.jade.service.ConnectionPool;
import com.jade.service.impl.ConnectionPoolImpl;

import java.sql.Connection;

public class ConnectionPoolManager {
	private static DBConfig dbBean = new DBConfig();
	private static ConnectionPool connectionPool = new ConnectionPoolImpl(dbBean);

	// 获取连接(重复利用机制)
	public static Connection getConnection() {
		return connectionPool.getConnection();
	}

	// 释放连接(可回收机制)
	public static void releaseConnection(Connection connection) {
		connectionPool.releaseConnection(connection);
	}
}
