<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>DASHMIN - Bootstrap Admin Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<div class="container-xxl position-relative bg-white d-flex p-0">

		<%@ include file="sidebar.jsp"%>

		<div class="content">
			<%@ include file="header.jsp"%>


			<!-- Form Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="row g-4">
					<div class="col-sm-12 col-xl-6">
						<div class="bg-light rounded h-100 p-4">
							<h6 class="mb-4">Add Sub Product</h6>
							<form method="post" action="../AdminController"
								enctype="multipart/form-data">
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Product
										Name : </label> <select class="form-control" name="productid">
										<option>--Select Product Name--</option>
										<%
                                    	Connection cn=new DBUtil().getConnectionData();
                                    	String qry="select * from product";
                                    	PreparedStatement st=cn.prepareStatement(qry);
                                    	ResultSet rs=st.executeQuery();
                                    	while(rs.next())
                                    	{
                                   %>
										<option value="<%= rs.getInt(1)%>"><%=rs.getString(2) %>(<%=rs.getString(6) %>)
										</option>
										<%
                                    	}
                                    %>
									</select>

								</div>
								<div class="mb-3">
									<label class="form-label">SubProduct Name :</label> <input
										type="text" class="form-control" name="subproductname">
								</div>
								<div class="mb-3">
									<label class="form-label">Main View Image :</label> <input
										type="file" class="form-control" name="subproductimage1">
								</div>
								<div class="mb-3">
									<label class="form-label">Second Image :</label> <input
										type="file" class="form-control" name="subproductimage2">
								</div>
								<div class="mb-3">
									<label class="form-label">Third Image :</label> <input
										type="file" class="form-control" name="subproductimage3">
								</div>
								<div class="mb-3">
									<label class="form-label">Price :</label> <input type="text"
										class="form-control" name="subproductprice">
								</div>
								<div class="mb-3">
									<label class="form-label">SubProduct Detail : </label> <input
										type="text" class="form-control" name="subproductdetail">
								</div>
								<div class="mb-3">
									<label class="form-label">SubProduct In stock : </label> <input
										type="text" class="form-control" name="avalibleproduct">
								</div>

								<button type="submit" name="action" value="addsubproduct"
									class="btn btn-primary">Add Sub Product</button>
							</form>


						</div>
					</div>

				</div>
			</div>
			<!-- Form End -->

			<%@ include file="footer.jsp"%>

		</div>
		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
			class="bi bi-arrow-up"></i></a>
	</div>
	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/chart/chart.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/tempusdominus/js/moment.min.js"></script>
	<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>

</html>