package org.example;

import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{

    @Transactional(rollbackFor = Exception.class)
    public void A() throws SQLException {
        Connection connection = getConnnection();
        String sql = "update teacher set t_name = ? where t_name = \"张三\"";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"二麻子");
        preparedStatement.execute();
    }
    @Transactional(rollbackFor = Exception.class)
    public void B() throws SQLException {
        try {
            A();
        }
        catch (SQLException e){
            e.printStackTrace();
        throw e;
        }

        try {
            int a = 5/0;
        }catch (ArithmeticException  e){
            e.printStackTrace();
            throw e;
        }
    }






    public static Connection getConnnection() throws SQLException {
            String url = "jdbc:mysql://localhost:3306/test?";
            String name = "root";
            String password = "123456";

          return DriverManager.getConnection(url,name,password);
    }
}
