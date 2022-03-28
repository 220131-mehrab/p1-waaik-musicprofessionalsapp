package com.revature.waaik.musicprofessionalsapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProsRepo {
    @Autowired
    private DataSource dataSource;

    public ProsRepo() {
    }

    public ProsRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<Pros> getPros() {

        List<Pros> pros = new ArrayList<>();
        //ResultSet rSet = null;
        try {
            Connection connection = dataSource.getConnection();

            ResultSet rSet = connection.prepareStatement("select * from pros").executeQuery();
            while (rSet.next()) {
                //get columns in table and puts it into your Pros list
                pros.add(new Pros(rSet.getInt("proId"), rSet.getString("name"), rSet.getString("profession"), rSet.getString("phoneNumber"), rSet.getString("email"), rSet.getInt("fee")));

            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return pros;
    }

    public void insertPros (Pros newPros){

        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement stmt = connection.prepareStatement("insert into pros values (?,?,?,?,?,?)");
            stmt.setInt(1, newPros.getProId());
            stmt.setString(2, newPros.getName());
            stmt.setString(3, newPros.getProfession());
            stmt.setString(4, newPros.getPhoneNumber());
            stmt.setString(5, newPros.getEmail());
            stmt.setInt(6, newPros.getFee());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
