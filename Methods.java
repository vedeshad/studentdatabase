package jdbcproject;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods 
{     static Scanner sc = new  Scanner(System.in);
	
	static void insertMethod(Student a) 
	{
		
		Driver d;
		try 
		{
			d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&&password=vedesh");
			PreparedStatement pst = con.prepareStatement("insert into studentdetails values (?,?,?,?)");   
			
			pst.setInt(1, a.getId());
			pst.setString(2,a.getName());
			pst.setString(3, a.getEmail());
			pst.setLong(4, a.getContact());
			
			int check = pst.executeUpdate();
			if(check>0)
			{
				System.out.println("Student ID Added");
			}
			con.close();
		} 
		catch (SQLException e) 
		{
			System.out.println("Student ID Already Available");
		}
		
	}

	public static void deleteMethod(Student a1) throws SQLException 
	{
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&&password=vedesh");
		PreparedStatement pst = con.prepareStatement("delete from studentdetails where id=?");   
		
		pst.setInt(1, a1.getId());
		
		int check = pst.executeUpdate();
		System.out.println();
		if(check>0)
		{
			System.out.println("Student ID Deleted");
		}
		else
		{
			System.out.println("No Student ID Found");
		}
		con.close();
	}

	public static void retriveMethod(Student a2) 
	{
		Driver d=null;
		Connection con=null;
		PreparedStatement pst=null;
		try 
		{
			d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&&password=vedesh");
			System.out.println("Equal or Lesser or Greater");
			String val=sc.next();
			pst =con.prepareStatement("select * from studentdetails where id "+val+"?");
			pst.setInt(1, a2.getId());
			
			ResultSet rs = pst.executeQuery();
			boolean check = true;
			   while(rs.next())
			   {
			   		
				 System.out.println("Student ID = "+rs.getInt(1)+
						   "\nStudent Name = "+rs.getString(2)+
						   "\nStudent Email = "+rs.getString(3)+
						   "\nStudent Contact = "+rs.getLong(4));
				System.out.println("---------------------");
				 check=false;  	
			   }
			   if(rs.next()==false&&check==true)
			   {
			   	 System.out.println("NO Student Data Found");
			   }
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				pst.close();
				con.close();
				
			} 
			catch (SQLException e) 
			{

				e.printStackTrace();
			}
	
			
		}
	
	}
	
	static List<Student> findAll() throws SQLException
	{
		List<Student> list=new ArrayList<>();
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student? user=root&&password=vedesh");
		
		PreparedStatement pstmt=conn.prepareStatement("select * from studentdetails");
		
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4)));
		}
		
		return list;
		
	}
	
}
