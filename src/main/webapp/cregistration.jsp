<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-commerce</title>
</head>
<body>

	<%@ include file="cust-header.jsp"%>

	<%@ include file="banner.jsp"%>
	<h3>Registration Details</h3>
	<div class="col-lg-8">
		<form method="post" action="CustomerContraller"
			class="row contact_form">

			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="firstname" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'First name'" placeholder='First name'>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="lastname" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Last name'" placeholder='Last name'>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="gender" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Gender'" placeholder='Gender'>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="form-group">
					<input class="form-control" name="address" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Address'" placeholder='Address'>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="state" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'State'" placeholder='State'>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="city" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Town/City'" placeholder='Town/City'>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="pincode" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Pincode'" placeholder='Pincode'>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="mobno" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Mobile number'"
						placeholder='Mobile number'>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="whatsappno" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'WhatsApp number'"
						placeholder='WhatsApp number'>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="image" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Image'" placeholder='Image'>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<input class="form-control" name="email" type="text"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Email Address'"
						placeholder='Email Address'>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<input class="form-control" name="password" type="password"
						onfocus="this.placeholder = ''"
						onblur="this.placeholder = 'Password'" placeholder='Password'>
				</div>
			</div>


			<div class="col-md-12 form-group">

				<button type="submit" name="action" value="registration"
					class="btn_3">Registration</button>
				<button type="submit" name="action" value="cancel" class="btn_3">
					Cancel</button>

			</div>

		</form>
	</div>

	<%@ include file="container.jsp"%>
	<%@ include file="footer.jsp"%>

	<!-- jquery plugins here-->
	<script src="js/jquery-1.12.1.min.js"></script>
	<!-- popper js -->
	<script src="js/popper.min.js"></script>
	<!-- bootstrap js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- easing js -->
	<script src="js/jquery.magnific-popup.js"></script>
	<!-- swiper js -->
	<script src="js/swiper.min.js"></script>
	<!-- swiper js -->
	<script src="js/masonry.pkgd.js"></script>
	<!-- particles js -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<!-- slick js -->
	<script src="js/slick.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>
	<!-- custom js -->
	<script src="js/custom.js"></script>
</body>
</html>