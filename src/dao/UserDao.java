package dao;

import dto.LoginRequestDto;
import dto.LogResponseDto;
import dto.RegisterRequestDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;

import com.mysql.cj.api.jdbc.Statement;

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
	
	public LogResponseDto registerUser(RegisterRequestDto dto) {
		Connection conn = getConnection();
		System.out.println(conn.toString());
		System.out.println(dto.toString());
		
		LogResponseDto res = new LogResponseDto();
		
		if(conn != null) {
			String query = "INSERT INTO users(first_name,last_name,mobile,email,password) VALUES(?,?,?,?,?)";
			try {
				PreparedStatement stmt = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, dto.getFirstName());
				stmt.setString(2, dto.getLastName());
				stmt.setString(3, dto.getMobile() );
				stmt.setString(4, dto.getEmail());
				stmt.setString(5, dto.getPassword());
				int affectedRows = stmt.executeUpdate();
				if(affectedRows == 1) {
					ResultSet key = stmt.getGeneratedKeys();
					if(key.next())
					res.setUid(key.getInt(1));
					res.setFullName(dto.getFirstName()+" "+dto.getLastName());
				}else {
					throw new SQLException("user creation failed");
				}
				conn.close();
			}
			catch(SQLException e) {
				res.setErrorMsg(e.getMessage());
				System.out.println(e.getMessage());
			}
		}
		return res;
	}
	
	public LogResponseDto loginUser(LoginRequestDto reqDto) {
		Connection conn = getConnection();
		LogResponseDto resDto = new LogResponseDto();
		System.out.println(reqDto.toString());
		if(conn != null) {
			String query = "select uid,first_name,last_name from users where email=? and password=?";
			try{
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, reqDto.getEmail());
				stmt.setString(2, reqDto.getPassword());
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					System.out.println("user found:"+rs.getInt(1));
					resDto.setUid(rs.getInt(1));
					resDto.setFullName(rs.getString(2)+" "+rs.getString(3));
				}else {
					throw new SQLException("user not found");
				}
			}catch(SQLException e) {
				System.out.println("Error : "+e.getMessage());
				resDto.setErrorMsg(e.getMessage());
			}
			
		}
		return resDto;
	}
}
