package javadbtest;

import java.sql.*;

public class JavaDBTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost", "root", "d101");
        System.out.println("Database connected");

        Statement statement = connection.createStatement();
        statement.execute("DROP DATABASE IF EXISTS logins");

        statement.execute("CREATE DATABASE IF NOT EXISTS logins");
        System.out.println("Database Created.");

        statement.execute("USE logins");

        statement.execute("CREATE TABLE IF NOT EXISTS logins(\n"
                + "username varchar(20),\n"
                + "firstname varchar(20),\n"
                + "lastname varchar(20),\n"
                + "email varchar(45),\n"
                + "password varchar(20),\n"
                + "lastip varchar(15)\n"
                + ");");
        System.out.println("Table Created.");

        statement.execute("CREATE USER IF NOT EXISTS bhcc IDENTIFIED BY 'bhccd101'");
        System.out.println("User bhcc created with password bhccd101");

        statement.execute("INSERT INTO logins VALUES ('Andrew.Thomas', 'Andrew', 'Thomas', "
                + "'andrew.p.thomas24@gmail.com', 'password', '123.12.321.11')");
        System.out.println("Record 1 added");

        statement.execute("INSERT INTO logins VALUES ('xXEdge_LordXx', 'Gabriel', 'Reyes', "
                + "'gabereyes@overwatch.com', 'DIEDIEDIE', '11.235.44.123')");
        System.out.println("Record 2 added");
        
        statement.execute("INSERT INTO logins VALUES ('onerustyrn', 'Russell', 'Thomas', "
                + "'russthomas66@gmail.com', 'andrewismyson', '11.235.44.123')");
        System.out.println("Record 3 added");
        
        ResultSet resultSet = statement.executeQuery("SELECT firstname, lastname FROM logins WHERE lastIP = '11.235.44.123'");
        
        while (resultSet.next()){
            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
        }
    }

}
