
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.CustomerModel;
import com.util.DBUtil;


public class CustomerDao 
{
	Connection cn=null;
	
	public int customerRegistration(CustomerModel rmodel)
	{
		int x=0;
		cn=new DBUtil().getConnectionData();
		String qry="insert into customer(firstname,lastname,gender,address,state,city,pincode,mobno,whatsappno,email,password,image) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, rmodel.getFirstname());
			st.setString(2, rmodel.getLastname());
			st.setString(3, rmodel.getGender());
			st.setString(4, rmodel.getAddress());
			st.setString(5, rmodel.getState());
			st.setString(6, rmodel.getCity());
			st.setInt(7, rmodel.getPincode());
			st.setString(8, rmodel.getMobno());
			st.setString(9, rmodel.getWhatsappno());
			st.setString(10, rmodel.getEmail());
			st.setString(11, rmodel.getPassword());
			st.setString(12, rmodel.getImage());
			x=st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
		public CustomerModel customerLogin(CustomerModel lmodel)
		{
			CustomerModel model=null;
			cn=new DBUtil().getConnectionData();
			String qry="select * from customer where email=? and password=?";
			
			try 
			{
				PreparedStatement st=cn.prepareStatement(qry);
				st.setString(1, lmodel.getEmail());
				st.setString(2, lmodel.getPassword());
				ResultSet rs=st.executeQuery();
				if(rs.next())
				{
					model=new CustomerModel();
					model.setCustomerid(rs.getInt(1));
					model.setFirstname(rs.getString(2));
					model.setLastname(rs.getString(3));
					model.setGender(rs.getString(4));
					model.setAddress(rs.getString(5));
					model.setState(rs.getString(6));
					model.setCity(rs.getString(7));
					model.setPincode(rs.getInt(8));
					model.setMobno(rs.getString(9));
					model.setWhatsappno(rs.getString(10));
					model.setEmail(rs.getString(11));
					model.setPassword(rs.getString(12));
					model.setImage(rs.getString(13));
				}
				cn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return model;

	}

}
