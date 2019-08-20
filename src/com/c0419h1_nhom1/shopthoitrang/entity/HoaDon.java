package com.c0419h1_nhom1.shopthoitrang.entity;

import com.c0419h1_nhom1.shopthoitrang.jdbc.DBConnection;

import java.sql.*;

public class HoaDon extends DBConnection {
    private int id;
    private String ngayban;
    private int id_khachhang;
    private int id_nhanvien;
    private double tongtien;
    private double vat;
    private double thanhtien;

    public HoaDon() {
    }

    public HoaDon(String ngayban, int id_khachhang, double tongtien, double vat, double thanhtien){
        this.ngayban = ngayban;
        this.id_khachhang = id_khachhang;
        this.tongtien = tongtien;
        this.vat = vat;
        this.thanhtien = thanhtien;
    }

    public HoaDon(int id, String ngayban, int id_khachhang, int id_nhanvien, double tongtien, double vat, double thanhtien) {
        this.id = id;
        this.ngayban = ngayban;
        this.id_khachhang = id_khachhang;
        this.id_nhanvien = id_nhanvien;
        this.tongtien = tongtien;
        this.vat = vat;
        this.thanhtien = thanhtien;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayban() {
        return ngayban;
    }

    public void setNgayban(String ngayban) {
        this.ngayban = ngayban;
    }

    public int getId_khachhang() {
        return id_khachhang;
    }

    public void setId_khachhang(int id_khachhang) {
        this.id_khachhang = id_khachhang;
    }

    public int getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(int id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public boolean createHoaDon(HoaDon newHoaDon) throws SQLException {
        String sql = "INSERT INTO hoadon (ngayban,id_khachhang,id_nhanvien,tongtien,vat,thanhtien) VALUES (?,?,?,?,?,?)";

        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.setString(1, newHoaDon.getNgayban());
        statement.setInt(2, newHoaDon.getId_khachhang());
        statement.setInt(3, 1);
        statement.setDouble(4, newHoaDon.getTongtien());
        statement.setDouble(5, newHoaDon.getVat());
        statement.setDouble(6, newHoaDon.getThanhtien());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }
    public int getidhoadon() throws SQLException {
        String sql = "SELECT * FROM hoadon ORDER BY id DESC LIMIT 1";
        //Lấy chuỗi kết nối tới CSDL truyền vào biến conn
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();

        //Tạo đường dẫn kết nối tới CSDL
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet = statement.executeQuery(sql);
        int id = 0;
        if (resultSet.next()) {

            id = resultSet.getInt("id");
        }
        resultSet.close();
        statement.close();

        return id;
    }
}
