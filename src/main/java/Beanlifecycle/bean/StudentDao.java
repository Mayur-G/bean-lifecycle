package Beanlifecycle.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.web.bind.annotation.PostMapping;

public class StudentDao {

	// hardcoding
//	private String driver = "com.mysql.cj.jdbc.Driver";
//	private String url = "jdbc:mysql://127.0.0.1:3306/?user=root/fullstack";
//	private String userName = "root";
//	private String password = "root";

	private String driver;
	private String url;
	private String userName;
	private String password;
	Connection con;
	
	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
		System.out.println("setDriver");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		System.out.println("setUrl");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		System.out.println("setUserName");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		System.out.println("setPassword");
	}

	//@PostConstruct
	public void init() throws ClassNotFoundException, SQLException
	{
		System.out.println("calling init() method");
		createStudentDBConnection();
	}
	
	public void createStudentDBConnection() throws ClassNotFoundException, SQLException
	{
		System.out.println("Creating connection for StudentDB");
		Class.forName(driver);
		con = DriverManager.getConnection(url, userName, password);
	}
	
	public void selectAllRows() throws ClassNotFoundException, SQLException {
		System.out.println("Retrieving all student rows ");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM fullstack.marksheet");

		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String branch = rs.getString(3);
			int marks = rs.getInt(4);

			System.out.println("id : " + id + ", name : " + name + ", branch : " + branch + ", marks " + marks);
		}
	}

	public void deleteStudentRecord(int studentId) throws ClassNotFoundException, SQLException {
		Statement stmt = con.createStatement();
		stmt.executeUpdate("delete from fullstack.marksheet where student_id = " + studentId);
		System.out.println("Record deleted with the id : " + studentId);
	}
	
	public void closeConnection() throws SQLException
	{
		destroy();
	}
	
	//@PreDestroy
	public void destroy() throws SQLException
	{
		System.out.println("inside destroy() method ");
		con.close();
	}
}
