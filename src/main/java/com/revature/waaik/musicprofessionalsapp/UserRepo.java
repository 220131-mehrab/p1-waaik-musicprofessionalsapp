package com.revature.waaik.musicprofessionalsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRepo {
    @Autowired
    private DataSource dataSource;

    public UserRepo() {
    }

    public UserRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<User> getUser() {
        List<User> user = new ArrayList<>();

        try {
            Connection connection = dataSource.getConnection();
            ResultSet rSet = connection.prepareStatement("select * from customer").executeQuery();
            while (rSet.next()) {
                //get columns in table and puts it into your Pros list
                user.add(new User(rSet.getInt("userId"), rSet.getString("userName"), rSet.getString("userEmail"), rSet.getString("userPassword"), rSet.getInt("userCreditCard")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void insertUser(User newUser){

        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement stmt = connection.prepareStatement("insert into customer values (?,?,?,?,?)");
            stmt.setInt(1, newUser.getUserId());
            stmt.setString(2, newUser.getUserName());
            stmt.setString(3, newUser.getUserEmail());
            stmt.setString(4, newUser.getUserPassword());
            stmt.setLong(5, newUser.getUserCreditCard());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert:" + e.getMessage());
            e.printStackTrace();
        }
    }

}
