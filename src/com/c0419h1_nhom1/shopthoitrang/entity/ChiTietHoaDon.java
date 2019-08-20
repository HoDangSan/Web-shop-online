package com.c0419h1_nhom1.shopthoitrang.entity;

import com.c0419h1_nhom1.shopthoitrang.jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChiTietHoaDon extends DBConnection {
    private int id_hoadon;
    private int id_sanpham;
    private int soluong;
    private double gia;

    public ChiTietHoaDon(){}

    public ChiTietHoaDon(int id_hoadon, int id_sanpham, int soluong, double gia) {
        this.id_hoadon = id_hoadon;
        this.id_sanpham = id_sanpham;
        this.soluong = soluong;
        this.gia = gia;
    }

    public int getId_hoadon() {
        return id_hoadon;
    }

    public void setId_hoadon(int id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public int getId_sanpham() {
        return id_sanpham;
    }

    public void setId_sanpham(int id_sanpham) {
        this.id_sanpham = id_sanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public boolean createChiTietHoaDon(ChiTietHoaDon newChiTietHoaDon) throws SQLException {
        String sql = "INSERT INTO ChiTietHoaDon (id_hoadon,id_sanpham,soluong,gia) VALUES (?,?,?,?)";

        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.setInt(1, newChiTietHoaDon.getId_hoadon());
        statement.setInt(2, newChiTietHoaDon.getId_sanpham());
        statement.setInt(3, newChiTietHoaDon.getSoluong());
        statement.setDouble(4, newChiTietHoaDon.getGia());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

}
