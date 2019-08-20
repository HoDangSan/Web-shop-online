<%@ page import="com.c0419h1_nhom1.shopthoitrang.jdbc.DBConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.c0419h1_nhom1.shopthoitrang.entity.SanPham" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: SanArima
  Date: 24-Jun-19
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    DBConnection db = new DBConnection();
    Connection conn = db.getConnection();
    if(conn == null){
      out.print("connection fail!");
    }
    else{
      out.print("connection success! <br><br>");

      List<SanPham> listSessionCartSanpham = new ArrayList<>();
      int lengthListSessonSanpham = 0;
      session.setAttribute("lengthListSessonSanpham", lengthListSessonSanpham);
      session.setAttribute("listSessionCartSanpham", listSessionCartSanpham);

      out.print("<a href='/homes'>Home<a>");
    }
  %>
  </body>
</html>
