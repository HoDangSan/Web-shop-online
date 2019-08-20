package com.c0419h1_nhom1.shopthoitrang.entity;

import com.c0419h1_nhom1.shopthoitrang.jdbc.DBConnection;

import java.io.PrintWriter;
import java.sql.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SanPham {
    private int id;
    private String tensp;
    private String mieuta;
    private double gia;
    private int soluong;
    private double gianhap;
    private String ngayNhap;
    private int idLoai;
    private int idKieu;
    private int idNhasanxuat;
    private String hinhanh;
    private int soluongtronggio = 0;
    private double tonggia = 0;


    public SanPham() {
    }

    public SanPham(int id, String tensp, String mieuta, double gia, int soluong, double gianhap, String ngayNhap, int idLoai, int idKieu, int idNhasanxuat, String hinhanh) {
        this.id = id;
        this.tensp = tensp;
        this.mieuta = mieuta;
        this.gia = gia;
        this.soluong = soluong;
        this.gianhap = gianhap;
        this.ngayNhap = ngayNhap;
        this.idLoai = idLoai;
        this.idKieu = idKieu;
        this.idNhasanxuat = idNhasanxuat;
        this.hinhanh = hinhanh;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMieuta() {
        return mieuta;
    }

    public void setMieuta(String mieuta) {
        this.mieuta = mieuta;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGianhap() {
        return gianhap;
    }

    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    public int getIdKieu() {
        return idKieu;
    }

    public void setIdKieu(int idKieu) {
        this.idKieu = idKieu;
    }

    public int getIdNhasanxuat() {
        return idNhasanxuat;
    }

    public void setIdNhasanxuat(int idNhasanxuat) {
        this.idNhasanxuat = idNhasanxuat;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getSoluongtronggio() {
        return soluongtronggio;
    }

    public void setSoluongtronggio(int soluongtronggio) {
        this.soluongtronggio = soluongtronggio;
    }

    public List<SanPham> getAllProduct() {
        List<SanPham> listSanpham = new ArrayList<>();

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

        // Câu lệnh truy vấn SQL
        String sql = "SELECT id,tensp,mieuta,gia,soluong,gianhap,ngaynhap,id_loai,id_kieu,id_nhasanxuat,hinhanh FROM sanpham ORDER BY id DESC LIMIT 9";
        // region Thực thi stmt & lấy kết quả SELECT
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tensp = resultSet.getString("tensp");
                String mieuta = resultSet.getString("mieuta");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("soluong");
                double gianhap = resultSet.getDouble("gianhap");
                java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
                String ngaynhap = df.format(resultSet.getDate("ngaynhap"));
                int idLoai = resultSet.getInt("id_loai");
                int idKieu = resultSet.getInt("id_kieu");
                int idNhasanxuat = resultSet.getInt("id_nhasanxuat");
                String hinhanh = resultSet.getString("hinhanh");

                SanPham sanPham = new SanPham(id, tensp, mieuta, gia, soluong,
                        gianhap, ngayNhap, idLoai, idKieu, idNhasanxuat, hinhanh);

                listSanpham.add(sanPham);
            }
        } catch (SQLException el) {
            el.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSanpham;
    }

    public List<SanPham> searchProductByName(String nameString) throws SQLException {
        List<SanPham> productList = new ArrayList<>();

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

        String sql = "SELECT * FROM sanpham WHERE tensp LIKE '%" + nameString + "%';";

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tensp = resultSet.getString("tensp");
                String mieuta = resultSet.getString("mieuta");
                double gia = resultSet.getDouble("gia");
                int soluong = resultSet.getInt("soluong");
                int gianhap = resultSet.getInt("gianhap");
                String ngaynhap = resultSet.getString("ngaynhap");
                int id_loai = resultSet.getInt("id_loai");
                int id_kieu = resultSet.getInt("id_kieu");
                int id_nhasanxuat = resultSet.getInt("id_nhasanxuat");
                String hinhanh = resultSet.getString("hinhanh");

                SanPham sanPham = new SanPham(id, tensp, mieuta, gia, soluong,
                        gianhap, ngayNhap, id_loai, id_kieu, id_nhasanxuat, hinhanh);

                productList.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // region Giải phóng tài nguyên -- dành cho stmt
        try {
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    public SanPham getsanpham(int id) throws SQLException {
        SanPham sanpham = null;
        String sql = "SELECT * FROM sanpham WHERE id = ?";

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

            String tensp = resultSet.getString("tensp");
            String mieuta = resultSet.getString("mieuta");
            double gia = resultSet.getDouble("gia");
            int soluong = resultSet.getInt("soluong");
            double gianhap = resultSet.getDouble("gianhap");
            java.text.DateFormat df = new java.text.SimpleDateFormat("YYYY/MM/dd");
            String ngaynhap = df.format(resultSet.getDate("ngaynhap"));
            int id_loai = resultSet.getInt("id_loai");
            int id_kieu = resultSet.getInt("id_kieu");
            int id_nhasanxuat = resultSet.getInt("id_nhasanxuat");
            String hinhanh = resultSet.getString("hinhanh");

            sanpham = new SanPham(id, tensp, mieuta, gia, soluong, gianhap, ngaynhap, id_loai, id_kieu, id_nhasanxuat, hinhanh);
        }
        resultSet.close();
        statement.close();

        return sanpham;
    }


    public double getTonggia() {
        return tonggia;
    }

    public void setTonggia(double tonggia) {
        this.tonggia = tonggia;
    }
}
