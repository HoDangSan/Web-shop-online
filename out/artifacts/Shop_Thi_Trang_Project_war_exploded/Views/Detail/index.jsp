<%--
  Created by IntelliJ IDEA.
  User: SanArima
  Date: 25-Jun-19
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/favicon.png">
    <title>Welcome to FlatShop</title>
    <jsp:include page="../Shared/_linkcss.jsp"></jsp:include>
</head>

<body>
<div class="wrapper">
    <jsp:include page="../Shared/_header.jsp"></jsp:include>
    <div class="clearfix">
    </div>
    <div class="container_fullwidth">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="products-details">
                        <div class="preview_image">
                            <div class="preview-small">
                                <a>
                                    <img src="${pageContext.request.contextPath}/Content/images/products/${sanpham.getHinhanh()}"
                                         style="max-height: 260px; max-width: 300px; display: block; margin-left: auto; margin-right: auto;"
                                         alt="">
                                </a>
                            </div>
                        </div>
                        <form id="formDetail" action="/homes?action=addtocartInDetail&id=${sanpham.getId()}"
                              method="post">
                            <div class="products-description">
                                <h5 class="name" style="font-size: 25px;">
                                    ${sanpham.getTensp()}
                                </h5>
                                <p class="producer-detail">
                                    NSX:
                                    <span class=" light-red">${nhasanxuat.getTen()}</span>
                                </p>
                                <p class="description-detail">
                                    Mô tả: <span>${sanpham.getMieuta()}</span>
                                </p>
                                <hr class="border">
                                <div class="price">
                                    Giá :
                                    <span class="new_price" style="margin-left: 10px;"><fmt:formatNumber type="number"
                                                                                                         maxFractionDigits="3"
                                                                                                         value="${sanpham.getGia()}"/> VNĐ</span>
                                </div>
                                <hr class="border">
                                <div class="wided">
                                    <div class="qty">
                                        Số lượng &nbsp;&nbsp;: <input type="number" min="1" name="soluong" id="soluong"
                                                                      value="1" style="width: 100px;" required>
                                    </div>
                                    <div class="button_group">
                                        <a href="/homes">
                                            <button class="button" type="button"><i class="fa fa-exchange"></i></button>
                                        </a>
                                        <button type="submit" class="btn-cart btn-success">+ Giỏ Hàng</button>
                                        <a href="/cart">
                                            <button type="button" class="btn-cart btn-danger">Mua Ngay</button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="clearfix">
    </div>
    <jsp:include page="../Shared/_footer.jsp"></jsp:include>
</div>
<!-- Bootstrap core JavaScript==================================================-->
<jsp:include page="../Shared/_linkjs.jsp"></jsp:include>
</body>

</html>