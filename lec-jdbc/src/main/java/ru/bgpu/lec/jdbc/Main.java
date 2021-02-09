package ru.bgpu.lec.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:h2:file:./db";

        Base base = new Base(url);
        base.initDefault(20);

        try (Connection con = base.getConnection()) {
            Statement statement = con.createStatement();
            ResultSet set = statement.executeQuery(
              "SELECT * FROM customers order by name"
            );

            while(set.next()) {
                System.out.println(
                        set.getInt("id")+" "+
                        set.getString("name")+" "+
                        set.getInt("age")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
