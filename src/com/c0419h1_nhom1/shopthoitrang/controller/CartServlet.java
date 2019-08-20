package com.c0419h1_nhom1.shopthoitrang.controller;

import com.c0419h1_nhom1.shopthoitrang.entity.ChiTietHoaDon;
import com.c0419h1_nhom1.shopthoitrang.entity.HoaDon;
import com.c0419h1_nhom1.shopthoitrang.entity.Khachhang;
import com.c0419h1_nhom1.shopthoitrang.entity.SanPham;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private HoaDon hoadonDAO = new HoaDon();
    private ChiTietHoaDon ChiTietHoaDonDAO = new ChiTietHoaDon();
    private Khachhang khachhangDAO = new Khachhang();
    private SanPham sanPhamDAO = new SanPham();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "thanhtoan":
                try {
                    pay(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "remove":
                removeSessionSanpham(request, response);
                break;
            default:
                ShowCart(request, response);
                break;
        }

    }

    private void ShowCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        List<SanPham> listSessionSanpham = (List<SanPham>) session.getAttribute("listSessionCartSanpham");

        // Tính hóa đơn
        double tongtien = 0;
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            listSessionSanpham.get(i).setTonggia(listSessionSanpham.get(i).getGia()*listSessionSanpham.get(i).getSoluongtronggio());
            tongtien += listSessionSanpham.get(i).getTonggia();
        }

        double vat = tongtien * 0.015;
        double thanhtien = tongtien + vat;
        Map<String, Double> hoadon = new HashMap<>();
        hoadon.put("tongtien", tongtien);
        hoadon.put("vat", vat);
        hoadon.put("thanhtien", thanhtien);
        session.setAttribute("hoadon", hoadon);
        Map<String, Double> hoadonView = (Map<String, Double>) session.getAttribute("hoadon");

        request.setAttribute("hoadonView", hoadonView);
        request.setAttribute("listSessionSanpham", listSessionSanpham);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Cart/index.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pay(HttpServletRequest request,HttpServletResponse response) throws SQLException {

        String tenkh = request.getParameter("tenkh");
        String sodienthoaikh = request.getParameter("sodienthoaikh");
        String diachi = request.getParameter("diachi");
        String ghichu = request.getParameter("ghichu");

        String ngayban = LocalDate.now().format(DateTimeFormatter.ofPattern("YYYY/MM/dd"));


        // Lấy giỏ hàng về
        HttpSession session = request.getSession();
        List<SanPham> listSessionSanpham = (List<SanPham>) session.getAttribute("listSessionCartSanpham");

        // Tạo khách hàng
        Khachhang newKhachhang = new Khachhang(tenkh,sodienthoaikh,diachi,ghichu);
        this.khachhangDAO.createkhachhang(newKhachhang);
        int id_khachHang = this.khachhangDAO.getidkhachhang();

        Map<String, Double> hoadon = (Map<String, Double>) session.getAttribute("hoadon");
        // tạo hóa đơn
        HoaDon newHoaDon = new HoaDon(ngayban,id_khachHang,hoadon.get("tongtien"),hoadon.get("vat"),hoadon.get("thanhtien"));
        this.hoadonDAO.createHoaDon(newHoaDon);
        int id_hoadon = this.hoadonDAO.getidhoadon();
        // Tạo chi tiết hóa đơn
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            ChiTietHoaDon newChiTietHoaDon = new ChiTietHoaDon(id_hoadon,listSessionSanpham.get(i).getId()
            ,listSessionSanpham.get(i).getSoluongtronggio(),listSessionSanpham.get(i).getTonggia());
            this.ChiTietHoaDonDAO.createChiTietHoaDon(newChiTietHoaDon);
        }

        List<SanPham> listSessionCartSanpham = new ArrayList<>();
        int lengthListSessonSanpham = 0;
        session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
        session.setAttribute("listSessionCartSanpham", listSessionCartSanpham);
        Map<String, Double> hoadonnew = new HashMap<>();
        session.setAttribute("hoadonView",hoadonnew);

        List<SanPham> dssanpham = this.sanPhamDAO.getAllProduct();

        request.setAttribute("dssanpham", dssanpham);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Home/index.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeSessionSanpham(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        // Lấy dữ liệu từ session
        HttpSession session = request.getSession();
        List<SanPham> listSessionSanpham = (List<SanPham>) session.getAttribute("listSessionCartSanpham");
        int lengthListSessonSanpham = (int) session.getAttribute("lengthListSessonSanpham");

        // Tìm kiếm sản phẩm trong giỏ và xóa đi
        for (int i = 0; i < listSessionSanpham.size(); i++){
            if(listSessionSanpham.get(i).getId() == id){
                lengthListSessonSanpham -= listSessionSanpham.get(i).getSoluongtronggio();
                listSessionSanpham.remove(i);
            }
        }

        // Tính lại hóa đơn sau khi xóa hàng trong giỏ
        double tongtien = 0;
        for (int i = 0; i < listSessionSanpham.size() ; i++){
            listSessionSanpham.get(i).setTonggia(listSessionSanpham.get(i).getGia()*listSessionSanpham.get(i).getSoluongtronggio());
            tongtien += listSessionSanpham.get(i).getTonggia();
        }

        double vat = tongtien * 0.015;
        double thanhtien = tongtien + vat;
        Map<String, Double> hoadon = new HashMap<>();
        hoadon.put("tongtien", tongtien);
        hoadon.put("vat", vat);
        hoadon.put("thanhtien", thanhtien);
        session.setAttribute("hoadon", hoadon);
        Map<String, Double> hoadonView = (Map<String, Double>) session.getAttribute("hoadon");

        // Chỉnh sửa lại session
        session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
        session.setAttribute("listSessionSanpham", listSessionSanpham);

        //gủi hóa đơn và ds sản phẩm theo request
        request.setAttribute("hoadonView", hoadonView);
        request.setAttribute("listSessionSanpham", listSessionSanpham);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/Cart/index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
