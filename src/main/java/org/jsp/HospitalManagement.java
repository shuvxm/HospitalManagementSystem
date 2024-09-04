package org.jsp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagement {
	public static void main(String[] args) {
		Scanner sc;
		while (true) {
			System.out.println("1) add patient\n2) view patient details by id\n"
					+ "3) update deisease by id\n4) update phone no by id and name\n "
					+ "5) displayAllPatientsByDisesse\n6) displayAllPatientsByName\n"
					+ "7) deletePatientByID\n8) searchPatientByName");
			switch (new Scanner(System.in).nextInt()) {
				case 1:
					addPatient();
					System.out.println("------------");
					break;
				case 2:
					viewPatientDetails();
					System.out.println("------------");
					break;
				case 3:
					updateDiseaseByID();
					System.out.println("------------");
					break;
				case 4:
					updatePhoneByID_Name();
					System.out.println("------------");
					break;
				case 5:
					displayAllPatientsByDisesse();
					break;
				case 6:
					displayAllPatientsByName();
					break;
				case 7:
					deletePatientByID();
					break;
				case 8:
					searchPatientByName();
					break;
			}
		}

	}

	static void addPatient() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			ps = con.prepareStatement("insert into patients values(?,?,?,?,?,?,?) ");

			System.out.println("enter id");
			ps.setInt(1, sc.nextInt());

			System.out.println("enter name");
			ps.setString(2, sc.next());

			System.out.println("enter age");
			ps.setInt(3, sc.nextInt());

			System.out.println("enter gender");
			ps.setString(4, sc.next());

			System.out.println("enter phone number");
			ps.setLong(5, sc.nextLong());

			System.out.println("enter disease");
			ps.setString(6, sc.next());

			System.out.println("enter admission date");
			ps.setDate(7, Date.valueOf(sc.next()));

			int row = ps.executeUpdate();
			System.out.println(row + " : rows affected");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void updateDiseaseByID() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			ps = con.prepareStatement("UPDATE patients SET disease=? WHERE id=? ");
			System.out.println("UPDATE UR DISEASE BY ID");

			System.out.println("enter ur new disease?");
			ps.setString(1, sc.next());

			System.out.println("enter id");
			ps.setInt(2, sc.nextInt());

			int row = ps.executeUpdate();
			System.out.println(row + " : rows updated");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void viewPatientDetails() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			ps = con.prepareStatement("SELECT * FROM patients ");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getString(4)
						+ "," + rs.getLong(5) + "," + rs.getString(6));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void updatePhoneByID_Name() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			ps = con.prepareStatement("UPDATE patients SET phone=? WHERE id=? AND NAME=?");
			System.out.println("UPDATE UR PHONE NO BY ID AND NAME");

			System.out.println("enter ur new phone no ?");
			ps.setLong(1, sc.nextLong());

			System.out.println("enter id");
			ps.setInt(2, sc.nextInt());

			System.out.println("enter name");
			ps.setString(3, sc.next());

			int row = ps.executeUpdate();
			System.out.println(row + " : rows updated");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void displayAllPatientsByDisesse() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			ps = con.prepareStatement("SELECT * FROM patients WHERE disease=?");
			System.out.println("enter ur disease");
			ps.setString(1, sc.next());
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getString(4)
						+ "," + rs.getLong(5) + "," + rs.getString(6));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void displayAllPatientsByName() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			ps = con.prepareStatement("SELECT * FROM patients WHERE name=?");
			System.out.println("enter ur name");
			ps.setString(1, sc.next());
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getString(4)
						+ "," + rs.getLong(5) + "," + rs.getString(6));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void deletePatientByID() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			ps = con.prepareStatement("DELETE FROM patients WHERE id=?");
			System.out.println("enter ur id");
			ps.setInt(1, sc.nextInt());
			// rs = ps.executeQuery();
			// while(rs.next()) {
			// System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3)+","+rs.getString(4)+","+rs.getLong(5)+","+rs.getString(6));
			// }
			int row = ps.executeUpdate();
			System.out.println(row + " : rows affected");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	static void searchPatientByName() {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
			ps = con.prepareStatement("SELECT * FROM patients WHERE NAME=? ");
			System.out.println("enter name?");
			ps.setString(1, sc.next());
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getString(4)
						+ "," + rs.getLong(5) + "," + rs.getString(6));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
