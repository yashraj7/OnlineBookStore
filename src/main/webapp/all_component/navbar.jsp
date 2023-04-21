<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<div class="container-fluid"
	style="height: 10px; background-color: #00695c;"></div>
<div class="container-fluid p-3">
	<div class="row">
		<div class="col-md-3 text-success">
			<h3>
				<i class="fa-solid fa-book"></i> Ebooks
			</h3>
		</div>
		<div class="col-md-6">
			<form class="form-inline my-2 my-lg-0" method="post"
				action="search.jsp">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search" name="ch">
				<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
		<c:if test="${not empty userObj }">
			<div class="col-md-3">
				<a href="checkout.jsp" class="btn btn-danger"><i
					class="fa-solid fa-cart-shopping"></i> cart</a> <a href="login.jsp"
					class="btn btn-success "><i class="fa-solid fa-user-plus"></i>
					${userObj.name }</a> <a href="logout"
					class="btn btn-primary text-white"><i
					class="fa-solid fa-arrow-right-to-bracket"></i> logout</a>
			</div>
		</c:if>
		<c:if test="${empty userObj }">
			<div class="col-md-3">
				<a href="login.jsp" class="btn btn-success"><i
					class="fa-solid fa-arrow-right-to-bracket"></i> Login</a> <a
					href="register.jsp" class="btn btn-primary text-white"><i
					class="fa-solid fa-user-plus"></i> Register</a>
			</div>
		</c:if>
	</div>

</div>
<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
	<a class="navbar-brand" href="#"><i class="fa-solid fa-house"></i></a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="all_new_book.jsp"><i class="fa-solid fa-book-open"></i>
					New Book</a></li>

			<li class="nav-item active"><a class="nav-link disabled"
				href="all_old_book.jsp"><i class="fa-solid fa-book-open"></i>
					Old Book</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<a href="setting.jsp" class="btn btn-Light my-2 my-sm-0 text-white"
				type="submit"> <i class="fa-solid fa-gears"></i> Setting

			</a> <a href="helpline.jsp" class="btn btn-Light my-2 my-sm-0 ml-1 text-white">
					<i class="fa-solid fa-square-phone"></i> Contact Us
			</a>

		</form>
	</div>
</nav>