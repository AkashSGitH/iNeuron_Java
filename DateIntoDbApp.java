package in.ineuron.dynamicinput;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import in.ineuron.jdbcUtil.JdbcUtil;

public class DateIntoDbApp {

	public static void main(String[] args) throws ParseException,SQLException
	{
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id :");
		int id = sc.nextInt();
		
		System.out.println("Enter your name:");
		String name = sc.next();
		
		System.out.println("Enter your Date of Birth (dd-mm-yyyy):");
		String sdob = sc.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date uDateOfBirth= sdf.parse(sdob);
		
		long dobtime = uDateOfBirth.getTime();
		java.sql.Date sqlDOB = new java.sql.Date(dobtime);
		
		System.out.println("Enter your Date of Joining (dd-mm-yyyy)");
		String sdoj = sc.next();
		java.util.Date uDateOfJoin = sdf.parse(sdoj);
		long dojtime = uDateOfJoin.getTime();
		java.sql.Date sqlDOJ = new java.sql.Date(dojtime);
		
		System.out.println("Enter your Date of Marraige (dd-mm-yyyy)");
		String sdom = sc.next();
		java.util.Date uDateOfMarr = sdf.parse(sdom);
		long domtime = uDateOfMarr.getTime();
		java.sql.Date sqlDOM = new  java.sql.Date(domtime);

		
		// add within the same insertQuery to add all the dates
		String insertSql = "INSERT INTO users(id,name,DOB,DOJ,DOM) VALUES(?,?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection!=null)
			{
				pst = connection.prepareStatement(insertSql);
				if(pst!=null)
				{
				pst.setInt(1,id);	
				pst.setString(2,name);
				pst.setDate(3, sqlDOB);
				pst.setDate(4,sqlDOJ);
				pst.setDate(5, sqlDOM);
				
				int noOfRows = pst.executeUpdate();
				System.out.println("No.of row(s) added : "+noOfRows);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter the id no. to see record :");
		id = sc.nextInt();
		
		String selectSql = "SELECT id,name,dob,doj,dom FROM users where id=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if(connection!=null)
			{
				pst = connection.prepareStatement(selectSql);
				if(pst!=null)
				{
					pst.setInt(1, id);
					resultSet = pst.executeQuery();
					if(resultSet.next())
					{
						System.out.println("ID\tNAME\tDOB\t\tDOJ\t\tDOM");
						System.out.println(resultSet.getString(1)+"\t"+
						resultSet.getString(2)+"\t"+resultSet.getDate(3)+"\t"+resultSet.getDate(4)+"\t"+resultSet.getDate(5));
							
					}
					else
					{
						System.out.println("No records found for the given id : "+id);
					}
				}
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.closeConnection(resultSet, pst, connection);
			if(sc!=null)
				sc.close();
		}
		
	}

}
