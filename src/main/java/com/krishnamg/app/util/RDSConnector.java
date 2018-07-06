package com.krishnamg.app.util;

import java.sql.*;
import java.util.logging.Logger;

public class RDSConnector {

    private static Logger logger = Logger.getLogger(RDSConnector.class.getCanonicalName());

    private String dbName = "wdb";
    private String userName = "root";
    private String password = "root";
    private String hostname = "localhost";
    private String port = "3306";

    public void myHandler() {
        try {
            Connection conn = getRDSConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from system");
            while (rs.next()) {
                StringBuilder sb = new StringBuilder(rs.getString(1));
                sb.append(" : ");
                sb.append(rs.getString(2));
                sb.append(" : ");
                sb.append(rs.getString(3));
                System.out.println(sb.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getRDSConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
            logger.warning("Getting remote connection with connection string from environment variables.");
            Connection con = DriverManager.getConnection(jdbcUrl);
            logger.info("Remote connection successful.");
            return con;
        } catch (ClassNotFoundException e) {
            logger.warning(e.toString());
        } catch (SQLException e) {
            logger.warning(e.toString());
        }
        return null;
    }

    /*public static void main(String args[]){
        new RDSConnector().myHandler();
    }*/

}
