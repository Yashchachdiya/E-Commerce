
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.ProductModel;
import com.util.DBUtil;

public class ProductDao {
	Connection cn =null;
	
	
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
	public ProductModel verifyLogin(int productid)
	{
		ProductModel model=null;
		cn=new DBUtil().getConnectionData();
		String qry="select * from product where productid=?";
		
		try {
			PreparedStatement st=cn.prepareStatement(qry);
			st.setInt(1, productid);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				model=new ProductModel();
				model.setProductid(rs.getInt(1));
				model.setProductname(rs.getString(2));
				model.setProductimage1(rs.getString(3));
				model.setProductimage2(rs.getString(4));
				model.setProductimage3(rs.getString(5));
				model.setCompanyname(rs.getString(6));
				model.setProductprice(rs.getString(7));
				model.setProductdetail(rs.getString(8));
				model.setAvalibleproduct(rs.getString(9));
			
			}
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	public int editproduct(ProductModel emodel)
	{
		int x = 0;
		cn = new DBUtil().getConnectionData();
		String qry = "UPDATE product SET productname = ?, productimage1 = ?, productimage2 = ?, productimage3 = ?,companyname = ?,productprice = ?,productdetail = ?,avalibleproduct = ? WHERE productid = ?";
		try 
		{	
			PreparedStatement st = cn.prepareStatement(qry);
			st.setString(1, emodel.getProductname());
			st.setString(2, emodel.getProductimage1());
			st.setString(3, emodel.getProductimage2());
			st.setString(4, emodel.getProductimage3());
			st.setString(5, emodel.getCompanyname());
			st.setString(6, emodel.getProductprice());
			st.setString(7, emodel.getProductdetail());
			st.setString(8, emodel.getAvalibleproduct());
			st.setInt(9, emodel.getProductid());
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
	
	public int delete(int productid)
	{
		int x=0;
		cn=new DBUtil().getConnectionData();
		String qry="delete from product where productid=?";
		
		try {
			PreparedStatement st=cn.prepareStatement(qry);
			st.setInt(1,productid);
			x=st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return x;
	}
	
}