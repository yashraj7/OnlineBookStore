<%@page import="in.code.entity.BookDetails"%>
<%@page import="in.code.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Books</title>
<%@ include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>
	
	<%
	int bid = Integer.parseInt(request.getParameter("bid"));
	BookDaoImpl dao = new BookDaoImpl();
	BookDetails b = dao.getBookById(bid);
	%>
	<div class="container">

		<div class="row">
			<div class="col-md-6 text-center p-5 border">
				<img src="book/<%=b.getPhotoName() %>" style="height: 150px; width: 100px;" /><br>
				<h4 class="mt-3">
					Book Name :<span class="text-success"> <%=b.getBookName()%></span>
				</h4>
				<h4 class="mt-3">
					Author name :<span class="text-success"> <%=b.getAuthor()%></span>
				</h4>
				<h4 class="mt-3">
					Category :<span class="text-success"> <%=b.getBookCategory()%></span>
				</h4>
			</div>
			<div class="col-md-6 text-center p-5 border">
				<h2><%=b.getBookName()%></h2>
				<div class="row">
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fa-solid fa-money-bill-wave fa-2x"></i>
						<p>Cash On Delivery</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fa-solid fa-rotate-left fa-2x"></i>
						<p>Return Available</p>
					</div>
					<div class="col-md-4 text-danger text-center p-2">
						<i class="fa-solid fa-truck fa-2x"></i>
						<p>Free Shipping</p>
					</div>

				</div>
				<div class="text-center p-3">
					<a href="" class="btn btn-primary"><i
						class="fa-solid fa-cart-shopping"></i> Add to Cart</a> <a href=""
						class="btn btn-danger"><i
						class="fa-solid fa-indian-rupee-sign"></i> <%= b.getPrice() %></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>