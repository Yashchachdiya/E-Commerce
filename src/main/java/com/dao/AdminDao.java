
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.ProductModel;
import com.model.SubProductModel;
import com.util.DBUtil;

public class AdminDao {
	Connection cn =null;
	Connection cn1 =null;
	
	public int addProduct(ProductModel pmodel)
	{
		int x = 0;
		cn = new DBUtil().getConnectionData();
		String qry = "insert into product(productname,productimage1,productimage2,productimage3,companyname,productprice,productdetail,avalibleproduct) values(?,?,?,?,?,?,?,?)";
		try 
		{	
			PreparedStatement st = cn.prepareStatement(qry);
			st.setString(1, pmodel.getProductname());
			st.setString(2, pmodel.getProductimage1());
			st.setString(3, pmodel.getProductimage2());
			st.setString(4, pmodel.getProductimage3());
			st.setString(5, pmodel.getCompanyname());
			st.setString(6, pmodel.getProductprice());
			st.setString(7, pmodel.getProductdetail());
			st.setString(8, pmodel.getAvalibleproduct());
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	public int addsubProduct(SubProductModel spmodel)
	{
		int x = 0;
		cn1 = new DBUtil().getConnectionData();
		String qry1 = "insert into subproduct(productid,subproductname,subproductimage1,subproductimage2,subproductimage3,subproductprice,subproductdetail,avalibleproduct) values(?,?,?,?,?,?,?,?)";
		try 
		{	
			PreparedStatement st1 = cn1.prepareStatement(qry1);
			st1.setInt(1, spmodel.getProductid());
			st1.setString(2, spmodel.getSubproductname());
			st1.setString(3, spmodel.getSubproductimage1());
			st1.setString(4, spmodel.getSubproductimage2());
			st1.setString(5, spmodel.getSubproductimage3());
			st1.setString(6, spmodel.getSubproductprice());
			st1.setString(7, spmodel.getSubproductdetail());
			st1.setString(8, spmodel.getAvalibleproduct());
			
			
			x=st1.executeUpdate();
			cn1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

}