package edu.tutorial.db;

import edu.tutorial.classes.Clerk;
import edu.tutorial.classes.Customer;
import edu.tutorial.classes.GroceryItem;
import edu.tutorial.classes.Measures;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vladimirkr on 7/15/2015.
 */
public class DBConnector {
    Connection connection;

    public void initConnection() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
        createDB();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public void createDB() throws Exception {
        Logger.getLogger(DBConnector.class).info("CreateDB()");
        Statement statement = (Statement) connection.createStatement();

        statement.setQueryTimeout(30);

        statement.executeUpdate("drop table if exists grocery");
        statement.executeUpdate("drop table if exists clerk");
        statement.executeUpdate("drop table if exists customer");
        statement.executeUpdate("drop table if exists measure");

        statement.executeUpdate("create table grocery (id integer PRIMARY KEY AUTOINCREMENT NOT NULL, name string UNIQUE, price integer, amount integer, measure string)");
        statement.executeUpdate("create table clerk (id integer PRIMARY KEY AUTOINCREMENT NOT NULL, name string UNIQUE)");
        statement.executeUpdate("create table customer (id integer PRIMARY KEY AUTOINCREMENT NOT NULL, name string UNIQUE)");
        statement.executeUpdate("create table measure (id integer PRIMARY KEY AUTOINCREMENT NOT NULL , name string UNIQUE, short_name string)");

        for (Measures item:Measures.values()) {
            statement.executeUpdate("insert into measure (name, short_name) values ('"+item.getValueName()+"', '"+item.getShortening()+"')");
        }


        statement.close();
    }

    public void registerClerk(Clerk item) throws SQLException {
        Logger.getLogger(DBConnector.class).info("Register Clerk "+item.toString());
        Statement statement = (Statement) connection.createStatement();
        statement.setQueryTimeout(30);
        statement.executeUpdate("insert into clerk (name) values ('" + item.getName() + "')");
        statement.close();
    }

    public void registerCustomer(Customer item) throws SQLException {
        Logger.getLogger(DBConnector.class).info("Register Customer "+item.toString());
        Statement statement = (Statement) connection.createStatement();
        statement.setQueryTimeout(30);
        statement.executeUpdate("insert into customer (name) values ('" + item.getName() + "')");
        statement.close();
    }

    public void registerGroceryItem(GroceryItem item) throws SQLException {
        Logger.getLogger(DBConnector.class).info("Register Grocery "+item.toString());
        Statement statement = (Statement) connection.createStatement();
        statement.setQueryTimeout(30);
        statement.executeUpdate("insert into grocery (name, price, amount, measure) values ('" + item.getName()+"', '"+item.getPrice()+"', '"+item.getAmount()+"', '"+item.getMeasure().getValueName() + "')");
        statement.close();
    }
}
