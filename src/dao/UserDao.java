package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import com.mysql.cj.api.jdbc.Statement;

import modals.User;

public class UserDao {
	private ServletContext cxt;
	public UserDao(ServletContext cxt) {
		this.cxt = cxt;
	}
	public Connection getConnection() {
		String dbUrl = cxt.getInitParameter("databaseURL");
		String dbUser = cxt.getInitParameter("dBUsername");
		String dbPass = cxt.getInitParameter("dBPassword");
		System.out.println(dbUrl+dbUser+dbPass);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			System.out.println("conn in userDao");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;			
	}
	public void addUser(User user) {
		Connection conn = getConnection();
		if(conn != null) {
			String query = "INSERT INTO users(first_name,last_name,address,city,state,pincode,dob,mobile,email,password)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement stmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, user.getFirstName());
				stmt.setString(2, user.getLastName());
				stmt.setString(9, user.getEmail());
				stmt.setString(10, user.getPassword());
				
				int i = stmt.executeUpdate();
				System.out.println("inserted in user rows :"+i);

			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
