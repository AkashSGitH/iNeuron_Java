package in.ineuron.Assignment4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.Scanner;

public class CRUDOperations {
	
	// Add all the CRUD methods 
	public static void insertRecord() throws SQLException
	{
		Connection con= null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
		// <main-protocol>:<sub-protocol>://localhost:<portnumber>/<db name>
		String url = "jdbc:mysql://localhost:3306/javaassing";
		String user = "root";
		String pwd = "akash12345";
		
		try
		{
			con = DriverManager.getConnection(url,user, pwd) ;
			if(con!=null)
			{
				st = con.createStatement();
				if(st!=null)
				{
					int id,age;
					String name;
					String addr;
					
					System.out.println("Please enter the details");
					
					System.out.println("Enter the id :");
					id = sc.nextInt();
					System.out.println("Enter the name :");
					name = sc.next();
					System.out.println("Enter the age :");
					age = sc.nextInt();
					System.out.println("Enter the address :");
					addr = sc.next().toUpperCase();
					
					String insertQuery = String.format("INSERT INTO student(sid,sname,sage,saddr) VALUES(%d,'%s',%d,'%s');",id,name,age,addr);
					
					int noOfRows = st.executeUpdate(insertQuery);
					System.out.println("New record(s) added to the table: "+noOfRows +"\n");
				}
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(con!=null) {
				con.close();
			}
			if(st!=null)
			{
				st.close();
			}
			sc.close();
		}
	}
	
	public static void readRecord() throws SQLException
	{
		Connection con = null;
		Statement st = null;
		
		String url = "jdbc:mysql://localhost:3306/javaassing";
		String user= "root";
		String pwd = "akash12345";
		
		try
		{
			con = DriverManager.getConnection(url,user,pwd);
			if(con!=null)
			{	
				st = con.createStatement();
				if(st!=null)
				{
					int id, age;
					String name,addr;
					
					String readQuery = "select sid, sname, sage, saddr from student;";
					
					ResultSet rs = st.executeQuery(readQuery);
					
					System.out.println("SID\tSNAME\tSAGE\tSADDR");
					
					while(rs.next())
					{
						id = rs.getInt("sid");
						name = rs.getString("sname");
						age = rs.getInt("sage");
						addr = rs.getString("saddr");
						System.out.println( id+"\t"+name+"\t"+age+"\t"+addr );
					}
					
					
				}
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) {
				con.close();
			}
			if(st!=null) {
				st.close();
			}
		}
	}
	
	public static void deleteRecord() throws SQLException
	{
		Connection con = null;
		Statement st = null;
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/javaassing";
		String user = "root";
		String pwd = "akash12345";
		
		try
		{
			con = DriverManager.getConnection(url,user,pwd);
			
			if(con!=null)
			{
				st = con.createStatement();
				if(st!=null)
				{
					System.out.println("Enter the Student ID Number:");
					int id = sc.nextInt();
					
					String deleteQuery= "DELETE FROM student WHERE sid="+id;
					int noOfRows = st.executeUpdate(deleteQuery);
					
					System.out.println("Number of rows deleted:"+noOfRows);
				}
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				con.close();
			}
			if(st!=null) {
				st.close();
			}
			sc.close();
		}
	}
	
	public static void updateRecord() throws SQLException
	{
		Connection con = null;
		Statement st = null;
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:mysql://localhost:3306/javaassing";
		String user = "root";
		String pwd = "akash12345";
		
		try
		{
			con = DriverManager.getConnection(url,user,pwd);
			if(con!=null)
			{
				st = con.createStatement();
				if(st!=null)
				{
					int id, age;
					String name,addr;
					
					System.out.println("Enter the Student's Id Number :");
					id=sc.nextInt();
				
					System.out.print("You want to change age?(Y/N)");
					String choice=sc.next().toUpperCase();
					if(choice.equals("Y"))
					{
						System.out.println("Enter the new age value :");
						age=sc.nextInt();
						String updateQuery = "UPDATE student set sage ="+ age + "where sid="+id+";";
							
						int noOfRows = st.executeUpdate(updateQuery);
						
						System.out.println("New record(s) added to the table: "+noOfRows +"\n");
					}
				}
			}
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				con.close();
			}
			if(st!=null)
			{
				st.close();
			}
			if(sc!=null)
			{
				sc.close();
			}
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int option;
		System.out.println("\t\tInteract with Student Table\n");
		do
		{
			System.out.println("Press 1.Insert  2.Read  3.Update  4.Delete    9.Terminate Operation");
			System.out.println("Enter option to perform task:");
			
			option=sc.nextInt();
			
			switch(option)
			{
				case 1-> {insertRecord();  // call static insert method
				 			System.out.println("calling insert method");
						}
				case 2-> {readRecord();    // call static read method
							System.out.println("calling read method");
						}			
				
				case 3->{ updateRecord(); // call static Update method
							System.out.println("calling update method");
						}
				
				case 4->{ deleteRecord();  // call static delete method
							System.out.println("calling delete method");
						}
				
				case 9->	System.out.println("Terminating Operation");
					
				default -> System.out.println("INVALID SELECTION");
			}
		}while(option!=9);
		
//		sc.close();
	}

}
