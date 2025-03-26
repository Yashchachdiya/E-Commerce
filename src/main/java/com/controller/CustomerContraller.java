package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDao;
import com.model.CustomerModel;


@WebServlet("/CustomerContraller")
public class CustomerContraller extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public CustomerContraller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("registration"))
		{
			CustomerModel cmodel=new CustomerModel();
			cmodel.setFirstname(request.getParameter("firstname"));
			cmodel.setLastname(request.getParameter("lastname"));
			cmodel.setGender(request.getParameter("gender"));
			cmodel.setAddress(request.getParameter("address"));
			cmodel.setState(request.getParameter("state"));
			cmodel.setCity(request.getParameter("city"));
			cmodel.setPincode(Integer.parseInt(request.getParameter("pincode")));
			cmodel.setMobno(request.getParameter("mobno"));
			cmodel.setWhatsappno(request.getParameter("whatsappno"));
			cmodel.setEmail(request.getParameter("email"));
			cmodel.setPassword(request.getParameter("password"));
			cmodel.setImage(request.getParameter("image"));
			
			int x=new CustomerDao().customerRegistration(cmodel);
			if(x>0)
			{
				response.sendRedirect("clogin.jsp");
			}
			else
			{
				response.sendRedirect("cregistration.jsp");
			}
		}
		else if(action.equals("login"))
		{
			CustomerModel lmodel=new CustomerModel();
			lmodel.setEmail(request.getParameter("email"));
			lmodel.setPassword(request.getParameter("password"));
			
			CustomerModel model=new CustomerDao().customerLogin(lmodel);
			if(model !=null)
			{
				HttpSession session=request.getSession(true);
				session.setAttribute("model", model);
				session.setAttribute("firstname", model.getFirstname());
				session.setAttribute("lastname", model.getLastname());
				session.setAttribute("customerid", model.getCustomerid());
				response.sendRedirect("cust-home.jsp");
			}
			else
			{
				response.sendRedirect("cregistration.jsp");
			}
		}


	}

}
