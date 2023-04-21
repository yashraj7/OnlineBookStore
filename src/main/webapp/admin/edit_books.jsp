<%@page import="in.code.entity.BookDetails"%>
<%@page import="in.code.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin : Edit Books</title>
<%@ include file="allCss.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Edit Books</h4>
					
						<%
						int id = Integer.parseInt(request.getParameter("id"));
						BookDaoImpl dao = new BookDaoImpl();
						BookDetails bd = dao.getBookById(id);
						%>
						<form method="post" action="../edit_books">
							<input type="hidden" name="id" value="<%=bd.getBookId() %>" />
							<div class="form-group">
								<label for="exampleInputEmail1">Book Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="bname"
									value="<%=bd.getBookName() %>">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Author Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="author"
									value="<%=bd.getAuthor() %>">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Price</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="price"
									value="<%=bd.getPrice() %>">
							</div>

							<div class="form-group">
								<label for="inputState">Book Status</label> <select
									id="inputState" name="status" class="form-control">
									<% 
                                     if ("Active".equals(bd.getStatus())) {
                                     %>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
									<% } else {%>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>
									<% } %>

								</select>
							</div>

							<button type="submit" class="btn btn-primary text-center">update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>