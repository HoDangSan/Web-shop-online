<%--
  Created by IntelliJ IDEA.
  User: SanArima
  Date: 26-Jun-19
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="our-brand">
    <h3 class="title"><strong>Our </strong> Brands</h3>
    <div class="control"><a id="prev_brand" class="prev" href="#">&lt;</a><a id="next_brand" class="next"
                                                                             href="#">&gt;</a></div>
    <ul id="braldLogo">
        <li>
            <ul class="brand_item">
                <li>
                    <a href="#">
                        <div class="brand-logo"><img src="${pageContext.request.contextPath}/Content/images/envato.png" alt=""></div>
                    </a>
                </li>

            </ul>
        </li>
        <li>
            <ul class="brand_item">
                <li>
                    <a href="#">
                        <div class="brand-logo"><img src="${pageContext.request.contextPath}/Content/images/envato.png" alt=""></div>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
</div>
