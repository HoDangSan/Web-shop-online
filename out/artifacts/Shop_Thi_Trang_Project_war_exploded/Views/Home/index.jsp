<%@ page import="java.text.DecimalFormat" %><%--
  Created by IntelliJ IDEA.
  User: SanArima
  Date: 24-Jun-19
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/favicon.png">
    <title>Welcome to FlatShop</title>
    <!--linkcss-->
    <jsp:include page="../Shared/_linkcss.jsp"></jsp:include>
    <!--linkcss-->
</head>
<body id="home">
<div class="wrapper">
    <!--head-->
    <jsp:include page="../Shared/_header.jsp"></jsp:include>
    <!--head-->
    <div class="clearfix"></div>
    <!--slide-->
    <jsp:include page="../Shared/_slide.jsp"></jsp:include>
    <!--slide-->
    <div class="clearfix"></div>
    <div class="container_fullwidth">
        <div class="container">
            <!--body-->
            <div class="container_fullwidth">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="clearfix">
                            </div>
                            <div class="products-grid">
                                <div class="clearfix">
                                </div>
                                <div class="row">
                                    <c:forEach items='${requestScope["dssanpham"]}' var="sanpham">
                                        <div class="col-md-4 col-sm-6">
                                            <div class="products">
                                                <div class="thumbnail">
                                                    <a href="/homes?action=view&id=${sanpham.getId()}">
                                                        <img src="${pageContext.request.contextPath}/Content/images/products/${sanpham.getHinhanh()}"
                                                             style="max-height: 90%;" alt="Product Name">
                                                    </a>
                                                </div>
                                                <div class="productname">
                                                        ${sanpham.getTensp()}
                                                </div>
                                                <h4 class="price">
                                                    <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sanpham.getGia()}" /> VNĐ
                                                </h4>
                                                <div class="button_group">
                                                    <a href="/homes?action=addtocartInHome&id=${sanpham.getId()}">
                                                        <button class="button add-cart" type="button">
                                                            Add To Cart
                                                        </button>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="clearfix">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix">
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <!--body-->
            <div class="clearfix"></div>
            <!--producer-->
            <%--            <jsp:include page="../Shared/_producer.jsp"></jsp:include>--%>
            <!--producer-->
        </div>
    </div>
    <div class="clearfix"></div>
    <!--footer-->
    <jsp:include page="../Shared/_footer.jsp"></jsp:include>
    <!--footer-->
</div>
<!-- Bootstrap core JavaScript==================================================-->
<!--Linkjs-->
<jsp:include page="../Shared/_linkjs.jsp"></jsp:include>
<!--Linkjs-->
</body>
</html>
