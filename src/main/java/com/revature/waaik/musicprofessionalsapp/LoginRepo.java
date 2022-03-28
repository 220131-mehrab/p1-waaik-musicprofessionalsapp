package com.revature.waaik.musicprofessionalsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Repository
public class LoginRepo {
    @Autowired
    private DataSource dataSource;

    public LoginRepo(){

    }

    public LoginRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public void insertLogin(User newUser){

        try {
            Connection connection = dataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement("insert into customer values (?,?,?,?,?)");
        stmt.setInt(1, newUser.getUserId());
        stmt.setString(2, newUser.getUserName());
        stmt.setString(3, newUser.getUserEmail());
        stmt.setString(4, newUser.getUserPassword());
        stmt.setLong(5, newUser.getUserCreditCard());
        stmt.executeUpdate();
    } catch (
    SQLException e) {
        System.err.println("Failed to insert:" + e.getMessage());
        e.printStackTrace();
    }

}
}
