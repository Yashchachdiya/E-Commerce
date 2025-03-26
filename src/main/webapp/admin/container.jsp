<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Gallery</title>
<!-- Link to Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
</head>
<body>
	<section class="product spad">
		<div class="container">
			<div class="row property__gallery">
				<% 
                Connection cn=new DBUtil().getConnectionData();
                String qry="select * from product";
                PreparedStatement st=cn.prepareStatement(qry); 
                ResultSet rs=st.executeQuery(); 
                while(rs.next()) {
            %>
				<div class="col-lg-3 col-md-4 col-sm-6 mix women">
					<div class="card">
						<img src="../Image/<%=rs.getString(3)%>" class="card-img-top"
							alt="<%=rs.getString(2)%>">
						<div class="card-body">
							<%--  <h5 class="card-title"><a href="#">Product ID= <%=rs.getString(1)%></a></h5> --%>
							<h5 class="card-title">
								<a href="#"><%=rs.getString(2)%></a>
							</h5>
							<p class="card-text text-muted"><%=rs.getString(7)%></p>
							<a
								href="../ProductUpDeController.do?action=edit&productid=<%=rs.getString(1)%>"
								class="btn btn-primary btn-sm">Edit</a> <a
								href="../ProductUpDeController.do?action=delete&productid=<%=rs.getString(1)%>"
								class="btn btn-danger btn-sm">Delete</a>
						</div>
					</div>
				</div>
				<%
                }
                cn.close();
            %>
			</div>
		</div>
	</section>


</body>

</html>