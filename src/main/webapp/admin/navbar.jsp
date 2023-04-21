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
			<li class="nav-item active"><a class="nav-link" href="home.jsp">Home
					<span class="sr-only">(current)</span>
			</a></li>
		</ul>
	</div>
	<div class="col-md-3">
		<c:if test="${not empty userObj }">
			<a  class="btn btn-success text-white"><i
				class="fa-solid fa-user-plus"></i> ${userObj.name }</a>
			<a data-toggle="modal" data-target="#exampleModalCenter"
				class="btn btn-primary text-white"><i
				class="fa-solid fa-user-plus"></i> Logout</a>
		</c:if>
		<c:if test="${empty userObj }">
			<a href="../login.jsp" class="btn btn-success"><i
				class="fa-solid fa-arrow-right-to-bracket"></i> Login</a>
			<a href="../register.jsp" class="btn btn-primary text-white"><i
				class="fa-solid fa-user-plus"></i> Register</a>
		</c:if>

	</div>

	<!--START Logout Modal  -->

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body text-center">
				<h5>Are You Sure you want to Logout?</h5>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<a href="../logout" type="button" class="btn btn-primary text-white">logout</a>
				</div>
			</div>
		</div>
	</div>
	<!--END Logout Modal  -->
</nav>