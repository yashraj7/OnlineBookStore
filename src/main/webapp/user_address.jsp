<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Address</title>
<%@ include file="all_component/allCss.jsp"%>
</head>
<body>
	<%@ include file="all_component/navbar.jsp"%>
	<div class="container">

		<div class="row">

			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h5 class="text-center text-primary p-1">Add Address</h5>

						<div class="form-row">

							<div class="form-group col-md-6">
								<label for="inputPassword4">Address</label> <input type="text"
									class="form-control" id="inputPassword4">
							</div>
							<div class="form-group col-md-6">
								<label for="inputEmail4">Landmark</label> <input type="text"
									class="form-control" id="inputEmail4">
							</div>
						</div>

						<div class="form-row">

							<div class="form-group col-md-4">
								<label for="inputPassword4">city</label> <input type="text"
									class="form-control" id="inputPassword4" value="">
							</div>
							<div class="form-group col-md-4">
								<label for="inputEmail4">State</label> <input type="text"
									class="form-control" id="inputEmail4" value="">
							</div>
							<div class="form-group col-md-4">
								<label for="inputPassword4">Zip</label> <input type="text"
									class="form-control" id="inputPassword4" value="">
							</div>
						</div>

						<div class="text-center">
							<button class="btn btn-warning ">Add Address</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>