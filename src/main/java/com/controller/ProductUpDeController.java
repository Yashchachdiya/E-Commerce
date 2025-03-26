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

import com.dao.ProductDao;
import com.model.ProductModel;


@WebServlet("/ProductUpDeController.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, // 512MB
maxFileSize = 1024 * 1024 * 512, // 512MB
maxRequestSize = 1024 * 1024 * 512) // 512MB
public class ProductUpDeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProductUpDeController() {
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
		String action=request.getParameter("action");

		if(action.equals("edit"))
		{
		    int productid=Integer.parseInt(request.getParameter("productid"));
			ProductModel emodel =new ProductDao().verifyLogin(productid);
			request.setAttribute("emodel", emodel);
			request.getRequestDispatcher("/admin/editproduct.jsp").forward(request, response);	
		}
		else if(action.equals("delete"))
		{
			int productid=Integer.parseInt(request.getParameter("productid"));
			int x =new ProductDao().delete(productid);
			request.setAttribute("msg","Student record deleted successfully..");
			request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");
		
		     if (action.equals("updateproduct")) {
		    ProductModel emodel = new ProductModel();
		    emodel.setProductid(Integer.parseInt(request.getParameter("productid")));
		    emodel.setProductname(request.getParameter("productname"));
		    emodel.setCompanyname(request.getParameter("companyname"));
		    emodel.setProductprice(request.getParameter("productprice"));
		    emodel.setProductdetail(request.getParameter("productdetail"));
		    emodel.setAvalibleproduct(request.getParameter("avalibleproduct"));

		    String savePath = "D:\\New folder (3)\\E-Commerce\\src\\main\\webapp\\Image";

		    File fileSaveDir = new File(savePath);
		    if (!fileSaveDir.exists()) {
		        fileSaveDir.mkdirs();
		    }

		    Part file1 = request.getPart("productimage1");
		    if (file1 != null && file1.getSize() > 0) {
		        String fileName1 = extractFilename(file1);
		        file1.write(savePath + File.separator + fileName1);
		        emodel.setProductimage1(fileName1);
		    } else {
		        emodel.setProductimage1(request.getParameter("existingProductImage1"));
		    }

		    Part file2 = request.getPart("productimage2");
		    if (file2 != null && file2.getSize() > 0) {
		        String fileName2 = extractFilename(file2);
		        file2.write(savePath + File.separator + fileName2);
		        emodel.setProductimage2(fileName2);
		    } else {
		        emodel.setProductimage2(request.getParameter("existingProductImage2"));
		    }

		    Part file3 = request.getPart("productimage3");
		    if (file3 != null && file3.getSize() > 0) {
		        String fileName3 = extractFilename(file3);
		        file3.write(savePath + File.separator + fileName3);
		        emodel.setProductimage3(fileName3);
		    } else {
		        emodel.setProductimage3(request.getParameter("existingProductImage3"));
		    }

		    int x = new ProductDao().editproduct(emodel);

		    if (x > 0) 
		    {
		    	
		        //response.sendRedirect("AddProductController.do?action=edit&productid=" + emodel.getProductid());
		        System.out.println("Product Updated Successfully.");
		        //response.sendRedirect("/admin/dashboard.jsp");
		        request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
		        
		    } else {
		        response.sendRedirect("Product Not Updated...");
		    }
		}


		
		
		
	}

}
