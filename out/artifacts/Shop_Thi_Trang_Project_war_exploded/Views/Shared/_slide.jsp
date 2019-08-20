<%--
  Created by IntelliJ IDEA.
  User: SanArima
  Date: 25-Jun-19
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="hom-slider">
    <div class="container">
        <div id="sequence">
            <div class="sequence-prev"><i class="fa fa-angle-left"></i></div>
            <div class="sequence-next"><i class="fa fa-angle-right"></i></div>
            <ul class="sequence-canvas">
                <li class="animate-in">
                    <div class="flat-caption caption1 formLeft delay300 text-center"><span class="suphead">Thời trang Paris</span>
                    </div>
                    <div class="flat-caption caption2 formLeft delay400 text-center">
                        <h1>Bộ sưu tập mùa hè</h1>
                    </div>
                    <div class="flat-caption caption3 formLeft delay500 text-center">
                        <p>Flatshop - sự lựa chọn hoàn hảo</p>
                    </div>
                    <div class="flat-button caption4 formLeft delay600 text-center"><a class="more" href="#">Xem chi tiết</a></div>
                    <div class="flat-image formBottom delay200" data-duration="5" data-bottom="true"><img
                            src="${pageContext.request.contextPath}/Content/images/slider-image-01.png" alt=""></div>
                </li>
                <li>
                    <div class="flat-caption caption2 formLeft delay400">
                        <h1>Bộ sưu tập mùa đông</h1>
                    </div>
                    <div class="flat-caption caption3 formLeft delay500">
                        <h2>Flatshop - sự lựa chọn hoàn hảo</h2>
                    </div>
                    <div class="flat-button caption5 formLeft delay600"><a class="more" href="#">Xem chi tiết</a>
                    </div>
                    <div class="flat-image formBottom delay200" data-bottom="true"><img
                            src="${pageContext.request.contextPath}/Content/images/slider-image-02.png" alt=""></div>
                </li>
                <li>
                    <div class="flat-caption caption2 formLeft delay400 text-center">
                        <h1>Thời trang mới năm 2019</h1>
                    </div>
                    <div class="flat-caption caption3 formLeft delay500 text-center">
                        <br>
                        <p></p>
                        <p>Flatshop - sự lựa chọn hoàn hảo</p>
                    </div>
                    <p></p>
                    <div class="flat-button caption4 formLeft delay600 text-center"><a class="more" href="#">Xem chi tiết</a></div>
                    <div class="flat-image formBottom delay200" data-bottom="true"><img
                            src="${pageContext.request.contextPath}/Content/images/slider-image-03.png" alt=""></div>
                </li>
            </ul>
        </div>
    </div>
    <div class="promotion-banner">
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-sm-4 col-xs-4">
                    <div class="promo-box"><img src="${pageContext.request.contextPath}/Content/images/promotion-01.png" alt=""></div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-4">
                    <div class="promo-box"><img src="${pageContext.request.contextPath}/Content/images/promotion-02.png" alt=""></div>
                </div>
                <div class="col-md-4 col-sm-4 col-xs-4">
                    <div class="promo-box"><img src="${pageContext.request.contextPath}/Content/images/promotion-03.png" alt=""></div>
                </div>
            </div>
        </div>
    </div>
</div>
