<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Setting</title>
<%@ include file="all_component/allCss.jsp"%>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
}
</style>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>

	<c:if test="${empty userObj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<div class="container">
		<h3 class="text-center">Hello, ${userObj.name }</h3>
		<div class="row p-5">

			<div class="col-md-6">
				<a href="sell_book.jsp">
					<div class="card">
						<div class="card-body text-center">
							<div class="text-primary">
								<i class="fa-solid fa-book-open fa-3x"></i>
							</div>
							<h4>Sell Old Books</h4>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-6">
				<a href="edit_profile.jsp"><div class="card">
						<div class="card-body text-center">
							<div class="text-warning">
								<i class="fa-solid fa-id-card fa-3x"></i>
							</div>
							<h4>Login & Security</h4>
						</div>
					</div> </a>
			</div>

		

			<div class="col-md-6 mt-3">
				<a href="order.jsp"><div class="card">
						<div class="card-body text-center">
							<div class="text-danger">
								<i class="fa-solid fa-box-open fa-3x"></i>
							</div>
							<h4>My Order</h4>
							<p>Track Your Order</p>
						</div>
					</div> </a>
			</div>

			<div class="col-md-6 mt-3">
				<a href="helpline.jsp"><div class="card">
						<div class="card-body text-center">
							<div class="text-primary">
								<i class="fa-solid fa-circle-user fa-3x"></i>
							</div>
							<h4>Help Center</h4>
							<p>24/7 Service</p>
						</div>
					</div> </a>
			</div>




		</div>
	</div>
</body>
</html>