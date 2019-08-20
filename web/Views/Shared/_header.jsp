<%--
  Created by IntelliJ IDEA.
  User: SanArima
  Date: 25-Jun-19
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-2 col-sm-2">
                <div class="logo"><a href="/homes"><img src="${pageContext.request.contextPath}/Content/images/logo.png" alt="FlatShop"></a></div>
            </div>
            <div class="col-md-10 col-sm-10">
                <div class="header_top">
                    <div class="row">
                        <div class="col-md-3">
                        </div>
                        <div class="col-md-6">
                        </div>
                        <div class="col-md-3">
                            <ul class="usermenu">

                            </ul>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="header_bottom">
                    <ul class="option">
                        <li id="search" class="search">
                            <form method="post" action="/homes?action=search">
                                <input class="search-input-detail" type="text" name="search" placeholder="Nhập sản phẩm cần tìm kiếm...">
                                <input class="search-detail" type="submit" value="">
                            </form>
                        </li>
                        <li class="option-cart">
                            <a href="/cart" class="cart-icon"> <span class="cart_no"><%=(session.getAttribute("lengthListSessonSanpham") == null) ? 0 : session.getAttribute("lengthListSessonSanpham")%></span></a>
                        </li>
                    </ul>
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target=".navbar-collapse"><span class="sr-only">Toggle navigation</span><span
                                class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li style="top:15px;"><a class="active" href="/homes">TRANG CHỦ</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>