package ru.bgpu.lec.jdbc;

import java.sql.*;
import java.util.Random;

public class Base {

    private String url;

    public Base(String url) {
        this.url = url;
    }

    public void initDefault(int countDefault) {
        try(Connection connection = getConnection()) {
            Random random = new Random();
            String customerTableQuery =
                    "CREATE TABLE IF NOT EXISTS customers " +
                    "(id INTEGER PRIMARY KEY, name TEXT, age INTEGER)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(customerTableQuery);

            String checkCount = "SELECT count(id) from customers";
            ResultSet set = statement.executeQuery(checkCount);
            if(set.next()) {
                int count = set.getInt(1);
                System.out.println("init database find: "+count);
                if(count < countDefault) {
                    System.out.println("init default data: "+(countDefault-count));
                    String[] names = {"Вася","Петя","Коля","Ярополк","Славик"};
                    String customerInsert = "INSERT INTO customers "+
                            "(id, name, age) VALUES ";
                    for(int i = 0; i < countDefault-count; i++) {
                        customerInsert += "("+(i+1)+",\'"
                                +names[random.nextInt(names.length)]+"\',"
                                +(22+random.nextInt(9)-4)+")";
                        if(i < countDefault-count-1) {
                            customerInsert+=",";
                        }
                    }
                    int inCount = statement.executeUpdate(customerInsert);
                    System.out.println("insert: "+inCount);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
