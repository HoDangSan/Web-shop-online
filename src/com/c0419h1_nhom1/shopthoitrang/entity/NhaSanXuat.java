package com.c0419h1_nhom1.shopthoitrang.entity;

import com.c0419h1_nhom1.shopthoitrang.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NhaSanXuat {
    private int id;
    private String ten;

    public NhaSanXuat(){}

    public NhaSanXuat(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public NhaSanXuat getNhasanxuat(int id) throws SQLException {
        NhaSanXuat nhaSanXuat = null;
        String sql = "SELECT * FROM nhasanxuat WHERE id = ?";

        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String ten = resultSet.getString("ten");
            nhaSanXuat = new NhaSanXuat(id, ten);
        }
        resultSet.close();
        statement.close();



        return nhaSanXuat;
    }
}
