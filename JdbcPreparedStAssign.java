package in.ineuron.prepared.jdbcassignment.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import in.ineuron.prepared.jdbcassignment.utility.JdbcUtility;

public class JdbcPreparedStAssign {
	// Add CRUD methods

	public static void insert() throws SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id :");
		int id = sc.nextInt();

		System.out.println("Enter the name :");
		String name = sc.next();

		System.out.println("Enter the age :");
		int age = sc.nextInt();

		System.out.println("Enter the address :");
		String addr = sc.next().toUpperCase();

		String insertQuery = "INSERT INTO students(sid,sname,sage,saddr) VALUES (?,?,?,?)";
		try {
			connection = JdbcUtility.getJdbcConnection();

			if (connection != null) {
				pst = connection.prepareStatement(insertQuery);

				if (pst != null) {
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setInt(3, age);
					pst.setString(4, addr);

					int rowsAffected = pst.executeUpdate();

					System.out.println("Records added to the table :" + rowsAffected);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.closeConnection(null, pst, connection);

			if (sc != null) {
				sc.close();
			}
		}

	}

	public static void read() throws SQLException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultset = null;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the id:");
		int id = scanner.nextInt();

		String selectQuery = "SELECT sid, sname, sage, saddr FROM students WHERE sid = ?";

		try {
			connection = JdbcUtility.getJdbcConnection();
			if (connection != null) {
				pst = connection.prepareStatement(selectQuery);

				if (pst != null) {
					pst.setInt(1, id);
					resultset = pst.executeQuery();
				}
				if (resultset != null) {
					if (resultset.next()) {
						System.out.println("SID\tSNAME\tSAGE\tSADDR");
						System.out.println(resultset.getInt(1) + "\t" + resultset.getString(2) + "\t"
								+ resultset.getInt(3) + "\t" + resultset.getString(4));
					} else {
						System.out.println("Record Unavailable for the given id:" + id);
					}
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.closeConnection(resultset, pst, connection);
			if (scanner != null)
				scanner.close();
		}

	}

	public static void delete() throws SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the id which you want to remove:");
		int id = sc.nextInt();

		String deleteQuery = "DELETE FROM students WHERE sid = ?";

		try {
			connection = JdbcUtility.getJdbcConnection();
			if (connection != null) {
				pst = connection.prepareStatement(deleteQuery);
				pst.setInt(1, id);
				if (pst != null) {
					int noOfRowsAffected = pst.executeUpdate();
					System.out.println(noOfRowsAffected + " record(s) is removed from the table.");
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtility.closeConnection(null, pst, connection);
			if (sc != null) {
				sc.close();
			}
		}
	}

	public static void update() throws SQLException {
		Connection connection = null;
		PreparedStatement pst = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id no. you want to change :");
		int id = sc.nextInt();

		int choice=0;
		do {
			System.out.println("What you want to update?");
			System.out.println("1.Name\t2.Age\t3.Address");

			choice = sc.nextInt();
			switch (choice) {
			case 1 -> {
				String updateSql = "UPDATE students SET sname = ? where sid = ?";
				System.out.println("Enter the new name:");
				String newName = sc.next();
				try {
					connection = JdbcUtility.getJdbcConnection();
					if (connection != null) {
						pst = connection.prepareStatement(updateSql);
						if (pst != null) {
							pst.setString(2, newName);

							int noOfRows = pst.executeUpdate();
							System.out.println("Number of rows updated :" + noOfRows);
						}

					}
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JdbcUtility.closeConnection(null, pst, connection);
					sc.close();
				}
			}
			
			case 2 -> {
				String updateSql = "UPDATE students SET sage = ? where sid = ?";
				System.out.println("Enter the new age:");
				String newAge = sc.next();
				try {
					connection = JdbcUtility.getJdbcConnection();
					if (connection != null) {
						pst = connection.prepareStatement(updateSql);
						if (pst != null) {
							pst.setString(1, newAge);
							pst.setInt(2,id);

							int noOfRows = pst.executeUpdate();
							System.out.println("Number of rows updated :" + noOfRows);
						}

					}
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JdbcUtility.closeConnection(null, pst, connection);
					sc.close();
				}
			}
			
			case 3 -> {
				String updateSql = "UPDATE students SET saddr = ? where sid = ?";
				System.out.println("Enter the new name:");
				String newName = sc.next();
				try {
					connection = JdbcUtility.getJdbcConnection();
					if (connection != null) {
						pst = connection.prepareStatement(updateSql);
						if (pst != null) {
							pst.setString(1, newName);
							pst.setInt(2,id);

							int noOfRows = pst.executeUpdate();
							System.out.println("Number of rows updated :" + noOfRows);
						}

					}
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JdbcUtility.closeConnection(null, pst, connection);
					sc.close();
				}
			}
			
			default -> System.out.println("INVALID SELECTION \n TERMINATING PROCESS");
			
			}
		} while (choice>0 || choice <4);
	}

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		int option;
		System.out.println("\t\t JDBC PreparedStatement Application");

		do {
			System.out.println("Press 1.Insert	2.Read	3.Update   4.Delete	9.Terminate Operation");
			System.out.println("Enter option to perform task:");
			option = sc.nextInt();

			switch (option) {
			case 1 -> insert();// System.out.println("Insert method");

			case 2 -> read();

			case 3 ->  update();

			case 4 -> delete();

			case 9 -> System.out.println("Terminating Operation");

			}
		} while (option != 9);
		if(sc!=null)
			sc.close();
	}

}
