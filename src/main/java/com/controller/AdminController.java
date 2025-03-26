package com.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.AdminDao;
import com.model.ProductModel;
import com.model.SubProductModel;


@WebServlet("/AdminController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, // 512MB
maxFileSize = 1024 * 1024 * 512, // 512MB
maxRequestSize = 1024 * 1024 * 512) // 512MB
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }
    private String extractFilename(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String content : contentDisp.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
		if(action.equals("login"))
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if(username.equals("admin") && password.equals("admin"))
			{
				response.sendRedirect("admin/dashboard.jsp");
			}
			else
			{
				response.sendRedirect("admin/index.jsp");
			}
		}
		else if(action.equals("addproduct"))
		{
			ProductModel pmodel = new ProductModel();
			pmodel.setProductname(request.getParameter("productname"));
			pmodel.setCompanyname(request.getParameter("companyname"));
			pmodel.setProductprice(request.getParameter("productprice"));
			pmodel.setProductdetail(request.getParameter("productdetail"));
			pmodel.setAvalibleproduct(request.getParameter("avalibleproduct"));
			
			String savePath= "D:\\\\New folder (3)\\\\E-Commerce\\\\src\\\\main\\\\webapp\\\\Image";

		        File fileSaveDir = new File(savePath);
		        if (!fileSaveDir.exists()) {
		            fileSaveDir.mkdirs();
		        }

		            Part file1 = request.getPart("productimage1");
		            String fileName1 = extractFilename(file1);
		            file1.write(savePath + File.separator + fileName1);

		            Part file2 = request.getPart("productimage2");
		            String fileName2 = extractFilename(file2);
		            file2.write(savePath + File.separator + fileName2);

		            Part file3 = request.getPart("productimage3");
		            String fileName3 = extractFilename(file3);
		            file3.write(savePath + File.separator + fileName3);

		            pmodel.setProductimage1(fileName1);
		            pmodel.setProductimage2(fileName2);
		            pmodel.setProductimage3(fileName3);
			
			int x = new AdminDao().addProduct(pmodel);
			if(x>0)
			{
				response.sendRedirect("admin/dashboard.jsp");
			}
			else 
			{
				response.sendRedirect("admin/addnewproduct.jsp");
			}
		}
		else if(action.equals("addsubproduct"))
		{
			SubProductModel spmodel = new SubProductModel();
			spmodel.setProductid(Integer.parseInt(request.getParameter("productid")));
			spmodel.setSubproductname(request.getParameter("subproductname"));
			spmodel.setSubproductprice(request.getParameter("subproductprice"));
			spmodel.setSubproductdetail(request.getParameter("subproductdetail"));
			spmodel.setAvalibleproduct(request.getParameter("avalibleproduct"));
			
			String savePath= "D:\\\\New folder (3)\\\\E-Commerce\\\\src\\\\main\\\\webapp\\\\Image";

		        File fileSaveDir = new File(savePath);
		        if (!fileSaveDir.exists()) {
		            fileSaveDir.mkdirs();
		        }

		            Part file1 = request.getPart("subproductimage1");
		            String fileName1 = extractFilename(file1);
		            file1.write(savePath + File.separator + fileName1);

		            Part file2 = request.getPart("subproductimage2");
		            String fileName2 = extractFilename(file2);
		            file2.write(savePath + File.separator + fileName2);

		            Part file3 = request.getPart("subproductimage3");
		            String fileName3 = extractFilename(file3);
		            file3.write(savePath + File.separator + fileName3);

		            spmodel.setSubproductimage1(fileName1);
		            spmodel.setSubproductimage2(fileName2);
		            spmodel.setSubproductimage3(fileName3);
			
			int x = new AdminDao().addsubProduct(spmodel);
			if(x>0)
			{
				response.sendRedirect("admin/dashboard.jsp"); 
			}
			else 
			{
				response.sendRedirect("admin/addsubproduct.jsp");
			}
		}

	}

}
