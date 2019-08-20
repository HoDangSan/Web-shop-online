<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 6/25/2019
  Time: 2:06 PM
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
    <!--linkcss-->
    <jsp:include page="../Shared/_linkcss.jsp"></jsp:include>
    <!--linkcss-->
</head>

<body>
<div class="wrapper">
    <!-- header-->
    <jsp:include page="../Shared/_header.jsp"></jsp:include>
    <!-- header-->

    <div class="clearfix">
    </div>
    <!--   body contact-->
    <div class="container_fullwidth">
        <div class="container shopping-cart">
                    <h3 class="title">Shopping Cart</h3>
                    <div class="clearfix">
                    </div>
                    <form id="formThanhToan" action="/cart?action=thanhtoan" method="post">
                        <table class="shop-table">
                            <thead>
                            <tr>
                                <th style="width: 18%;">Hình ảnh</th>
                                <th style="width: 42%;">Thông tin</th>
                                <th>Giá</th>
                                <th>Số lượng</th>
                                <th>Thành tiền</th>
                                <th>Xóa</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items='${requestScope["listSessionSanpham"]}' var="sanpham">
                                <tr>
                                    <td>
                                        <a href="/homes?action=view&id=${sanpham.getId()}">
                                        <img src="${pageContext.request.contextPath}/Content/images/products/${sanpham.getHinhanh()}"
                                             alt="">
                                        </a>
                                    </td>
                                    <td style="width: 30%;" >
                                        <div class="shop-details">
                                            <div class="productname">${sanpham.getTensp()}</div>
                                            <p>
                                                Product Code :<strong class="pcode">Dress 120</strong>
                                            </p>
                                        </div>
                                    </td>
                                    <td>
                                        <h5><fmt:formatNumber type="number" maxFractionDigits="3" value="${sanpham.getGia()}"/><span> VNĐ</span></h5>
                                    </td>

                                    <td style="width: 6%;">
                                            ${sanpham.getSoluongtronggio()}
                                    </td>

                                    <td>
                                        <h5><a class="red"><fmt:formatNumber type="number" maxFractionDigits="3" value="${sanpham.getTonggia()}"/><span> VNĐ</span></a>
                                        </h5>
                                    </td>
                                    <td style="width: 6%;">
                                        <a href="/cart?action=remove&id=${sanpham.getId()}"><img
                                                src="${pageContext.request.contextPath}/Content/images/remove.png"
                                                alt=""></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="6">
                                    <button class=" pull-right"><a href="/homes">Tiếp tục mua sắm</a></button>
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                        <!-- Contact -->
                        <div class="row">
                        <div class="col-lg-6">
                            <div class="checkout-page">
                                <ol class="checkout-steps">
                                    <li class="steps active">
                                        <a class="step-title">Điền Thông tin liên hệ</a>
                                        <div class="step-description">
                                            <div class="row">
                                                <div class="run-customer">
                                                    <h5>Thông tin liên hệ</h5>
                                                    <div class="form-row">
                                                        <label class="lebel-abs">Tên<strong
                                                                class="red">*</strong></label>
                                                        <input type="text" class="input namefild" name="tenkh"
                                                               placeholder="Vui lòng nhập tên" required>
                                                    </div>
                                                    <div class="form-row"><label class="lebel-abs">Số điện
                                                        thoại<strong
                                                                class="red">*</strong></label>
                                                        <input type="text" class="input namefild" name="sodienthoaikh"
                                                               placeholder="Vui lòng nhập số điện thoại" required>
                                                    </div>
                                                    <div class="form-row"><label class="lebel-abs">Địa chỉ<strong
                                                            class="red">*</strong></label>
                                                        <input type="text" class="input namefild" name="diachi"
                                                               placeholder="Vui lòng nhập địa chỉ" required>
                                                    </div>
                                                    <div class="form-row"><label class="lebel-abs">Ghi chú<strong
                                                            class="red">*</strong></label>
                                                        <textarea type="text" class="input namefild" name="ghichu"
                                                                  rows="5" cols="72"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ol>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="checkout-page">
                                <ol class="checkout-steps">
                                    <li class="steps active">
                                        <a class="step-title">Bản Thanh Toán</a>
                                        <div class="step-description" style="padding-bottom: 6px;">
                                            <div class="row">
                                                <div><img style="margin-top: -22px;"
                                                          src="${pageContext.request.contextPath}/Content/images/bghoadon.jpg">
                                                </div>
                                                <div class="run-customer" style="margin-top: 10px;">
                                                    <div style="font-size: 22px;">Tổng tiền&ensp;: <span
                                                            style="color:red;"> <fmt:formatNumber type="number"
                                                                                                  maxFractionDigits="3"
                                                                                                  value='${requestScope["hoadonView"].get("tongtien")}'/> VNĐ </span>
                                                    </div>
                                                    <hr style="margin-top: 15px;margin-bottom: 10px;">
                                                    <div style="font-size: 22px;">Thuế VAT&ensp;: <span
                                                            style="color:red;"> <fmt:formatNumber type="number"
                                                                                                  maxFractionDigits="3"
                                                                                                  value="${requestScope['hoadonView'].get('vat')}"/> VNĐ</span>
                                                    </div>
                                                    <hr style="margin-top: 15px;margin-bottom: 10px;">
                                                    <div style="font-size: 22px;">Thành tiền: <span style="color:red;"> <fmt:formatNumber
                                                            type="number"
                                                            maxFractionDigits="3"
                                                            value="${requestScope['hoadonView'].get('thanhtien')}"/> VNĐ</span>
                                                    </div>
                                                </div>
                                                <button class="btn-cart btn-success"
                                                        style="margin-top: 22px;float: right;"
                                                        type="submit">
                                                    Thanh Toán
                                                </button>
                                            </div>
                                        </div>
                                    </li>
                                </ol>
                            </div>
                        </div>
                        </div>
                    </form>
                    <!--End Contact -->
        </div>
    </div>

    <!--    body contact-->
    <div class="clearfix">
    </div>
    <!--    footer-->
    <jsp:include page="../Shared/_footer.jsp"></jsp:include>
    <!--    footer-->
</div>
<script>
    $(document).ready(function () {
        $("#formThanhToan").validate({
            rules: {
                tenkh: {
                    required: true,
                },
                sodienthoaikh: {
                    required: true,
                    minlength: 5,
                    maxlength: 11,
                },
                diachi: {
                    required: true,
                    minlength: 2,
                }
            },
            messages: {
                tenkh: {
                    required: "Không được để trống",
                },
                sodienthoaikh: {
                    required: "Không được để trống",
                    minlength: "Số máy quý khách vừa nhập là số không có thực",
                    maxlength: "Số máy quý khách vừa nhập là số không có thực"
                },
                diachi: {
                    required: "Không được để trống",
                    minlength: "Địa chỉ quá ngắn"
                }
            }
        })
    });
</script>
</body>

</html>