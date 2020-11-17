package dao;

import beans.LoginBean;

import java.sql.*;
public class LoginDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fPortal?serverTimezone=UTC","root",""); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static int loginUser(LoginBean bean) {
		int uuid = 0; 
		return uuid;
	}
}
