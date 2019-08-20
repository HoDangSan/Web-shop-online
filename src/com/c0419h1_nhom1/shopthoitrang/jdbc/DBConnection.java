package com.c0419h1_nhom1.shopthoitrang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public DBConnection(){}
    public Connection getConnection() {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String myDB = "shopthoitrangdb";
            String url = "jdbc:mysql://" + serverName + "/" + myDB + "?useUnicode=true&characterEncoding=utf-8";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
