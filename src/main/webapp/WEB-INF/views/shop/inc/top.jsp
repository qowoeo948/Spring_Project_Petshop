<%@page import="com.koreait.petshop.model.domain.SubCategory"%>
<%@page import="com.koreait.petshop.model.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	List<TopCategory> topList = (List)request.getAttribute("topList");
%>
<style>
#logo3{
	text-align: center;
	
}
</style>
 <header class="header-section">
        <div class="header-top">
            <div class="container">
                <div class="ht-left">
                    <div class="mail-service">
                        <i class=" fa fa-envelope"></i>
                        qowoeo948@gmail.com
                    </div>
                    <div class="phone-service">
                        <i class=" fa fa-phone"></i>
                        010.3377.7086
                    </div>
                </div>
                <div class="ht-right">
                    <div class="top-social">
                        <a href="#"><i class="ti-facebook"></i></a>
                        <a href="#"><i class="ti-twitter-alt"></i></a>
                        <a href="#"><i class="ti-linkedin"></i></a>
                        <a href="#"><i class="ti-pinterest"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="inner-header">
                <div class="row">
                     <div class="col-lg-9 col-md-9">
                        <div class="logo">
                            <a href="./index.html">
                                <img src="/resources/img/logo2.png" alt="">
                            </a>
                        </div>
                    </div>
                   
                    <div class="col-lg-3 text-right col-md-3">
                        <ul class="nav-right">
                            <li class="heart-icon">
                                <a href="#">
                                    <i class="icon_heart_alt"></i>
                                    <span>1</span>
                                </a>
                            </li>
                            <li class="cart-icon">
                                <a href="#">
                                    <i class="icon_bag_alt"></i>
                                    <span>3</span>
                                </a>
                                <div class="cart-hover">
                                    <div class="select-items">
                                        <table>
                                            <tbody>
                                                <tr>
                                                    <td class="si-pic"><img src="/resources/img/select-product-1.jpg" alt=""></td>
                                                    <td class="si-text">
                                                        <div class="product-selected">
                                                            <p>$60.00 x 1</p>
                                                            <h6>Kabino Bedside Table</h6>
                                                        </div>
                                                    </td>
                                                    <td class="si-close">
                                                        <i class="ti-close"></i>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="si-pic"><img src="/resources/img/select-product-2.jpg" alt=""></td>
                                                    <td class="si-text">
                                                        <div class="product-selected">
                                                            <p>$60.00 x 1</p>
                                                            <h6>Kabino Bedside Table</h6>
                                                        </div>
                                                    </td>
                                                    <td class="si-close">
                                                        <i class="ti-close"></i>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="select-total">
                                        <span>total:</span>
                                        <h5>$120.00</h5>
                                    </div>
                                    <div class="select-button">
                                        <a href="#" class="primary-btn view-card">VIEW CARD</a>
                                        <a href="#" class="primary-btn checkout-btn">CHECK OUT</a>
                                    </div>
                                </div>
                            </li>
                            <li class="cart-price">$150.00</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="nav-item">
            <div class="container">
                <div class="nav-depart">
                    <div class="depart-btn">
                        <i class="ti-menu"></i>
                        <span>All departments</span>
                        <!-- ------------------------------------------------ -->
                        <ul class="depart-hover">
                        	<%for(TopCategory topCategory : topList) {%>
                            	<li style="border-bottom: 1px solid #EEEEEE;"><a href="/shop/product/topList?topcategory_id=<%=topCategory.getTopcategory_id()%>"><%=topCategory.getName() %></a></li>
                            <%} %>
                        </ul>
                    </div>
                </div>
                <nav class="nav-menu mobile-menu">
                    <ul>
                        <li><a href="/">Home</a></li>
                        <li><a href="/shop/product/topList?topcategory_id=1">Shop</a></li>
                        <li><a href="/shop/contact">Contact</a></li>
                        <li><a href="/shop/qna/list">QNA</a></li>
                        <li><a href="#">Management</a>
                           <ul class="dropdown">
                               	<%if(session.getAttribute("admin")!=null) {%>
                               	    <li><a href="/admin/product/list">Product</a></li>
                                	<li><a href="/admin/member/list">Member</a></li>
                                	<li><a href="#">Order</a></li>
	                                <li><a href="/admin/register">Register</a></li>
                               	<%}else{ %>
	                                <li><a href="/petshop/register">Register</a></li>
                               	<%} %>
                                <%if(session.getAttribute("member")==null && session.getAttribute("admin")==null){ //세션에 담겨진 데이터가 없다면%>
                                   <li><a href="/petshop/login">Login</a></li>
                                <%}else{ %>
                                   <li><a href="/petshop/logoutRequest">LogOut</a></li>
                                   <%if(session.getAttribute("admin")==null) {%>
                                   	<li><a href="/petshop/logoutRequest">Cart</a></li>
                                   <%} %>
                                <%} %>
                            </ul>
                        </li>
                    </ul>
                </nav>
                <div id="mobile-menu-wrap"></div>
            </div>
        </div>
    </header>