<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
              while(rs.next())
              {
            %>
				<div class="col-lg-3 col-md-4 col-sm-6 mix women">
					<div class="product__item">
						<div class="product__item__pic set-bg"
							data-setbg="Image/<%=rs.getString(3)%>">
							<div class="label new">New</div>
							<ul class="product__hover">
								<li><a href="Image/<%=rs.getString(3)%>"
									class="image-popup"><span class="arrow_expand"></span></a></li>

							</ul>
						</div>
						<div class="product__item__text">
							<h6>
								<a href="#"><%=rs.getString(2)%></a>
							</h6>

							<div class="product__price"><%=rs.getString(7)%></div>
						</div>

						<%--  <a href="editpeoduct.jsp?productid=<%=rs.getInt(1)%>" class="site-btn">Edit</a> --%>
						<a
							href="AddProductController.do?action=edit&productid=<%=rs.getString(1)%>"
							class="site-btn">Edit</a> <a
							href="AddProductController.do?action=delete&productid=<%=rs.getString(1)%>"
							class="site-btn">Delete</a>

					</div>
				</div>
				<%
           			 			}
            		cn.close();
            
            %>

			</div>
		</div>
	</section>
	<!-- Product Section End -->

</body>
</html>