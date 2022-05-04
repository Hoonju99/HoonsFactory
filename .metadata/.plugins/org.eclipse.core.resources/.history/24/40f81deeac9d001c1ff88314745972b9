<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="product-shop spad">
	<div class="container">
		<div class="row">
			<div
				class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
			</div>
		</div>
		<div class="col-lg-9 order-1 order-lg-2">
			<div class="product-show-option">
				<div class="row">
					<div class="col-lg-7 col-md-7">
						<div class="select-option">
							<select class="sorting">
								<option value="">Default Sorting</option>
							</select> <select class="p-show">
								<option value="">Show:</option>
							</select>
						</div>
					</div>
					<div class="col-lg-5 col-md-5 text-right">
						<p>Show 01- 09 Of 36 Product</p>
					</div>
				</div>
			</div>
						
			<div class="product-list">
				<div class="row">
					<c:forEach items="${bookList}" var="list">
					<c:if test='${list.bookNum eq 3 }'>
						<div class="col-lg-4 col-sm-6">
							<div class="product-item">
								<div class="pi-pic">
									<img src="img/products/product-1.jpg" alt="">
									<div class="sale pp-sale">Sale</div>
									<div class="icon">
										<i class="icon_heart_alt"></i>
									</div>
									<ul>
										<li class="w-icon active"><a href="#"><i
												class="icon_bag_alt"></i></a></li>
										<li class="quick-view"><a href="quickbuy.do">바로 구매</a></li>
										<li class="w-icon"><a href="#"><i
												class="fa fa-random"></i></a></li>
									</ul>
								</div>
								<div class="pi-text">
									<div class="catagory-name">${list.bookCompany }</div>
									<a href="#">
										<h5>${list.bookName }</h5>
									</a>
									<div class="product-price">
										₩ ${list.bookPrice } <span></span>
									</div>
								</div>
							</div>
						</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="loading-more">
				<i class="icon_loading"></i> <a href="#"> Loading More </a>
			</div>
		</div>
	</div>
	</div>
</section>