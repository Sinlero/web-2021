package ru.bgpu.lec.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:h2:mem:";
        try (Connection con = DriverManager.getConnection(url);
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT 1+1")) {
            if (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
