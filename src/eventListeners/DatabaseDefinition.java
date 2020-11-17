package eventListeners;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DatabaseDefinition implements ServletContextListener {

	public DatabaseDefinition() {
		System.out.println("servletContextListener: db definition");
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public void contextInitialized(ServletContextEvent event) {
		ServletContext cxt = event.getServletContext();
		String dbURL = (String) cxt.getInitParameter("databaseURL");
		String dbUsername = (String) cxt.getInitParameter("dBUsername");
		String dbPassword = (String) cxt.getInitParameter("dBPassword");

		System.out.println(dbURL);
		System.out.println(dbUsername);
		System.out.println(dbPassword);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			
			createDatabase(conn);
			
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	private void createDatabase(Connection conn) {
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			String []types = {"TABLE"};
			ResultSet rs = dbmd.getTables("fPortal",null,"%",types);
			if(rs.next()) {
				do {
					System.out.println(rs.getString(3));					
				}while(rs.next());
			}else {
				Statement stmt = conn.createStatement();
				String userTable = "create table users (" +
									"uid INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, "+
									"first_name VARCHAR(20) NOT NULL ,"+
									"last_name VARCHAR(20) , "+
									"address VARCHAR(50) NOT NULL ,"+
									"city VARCHAR(30) NOT NULL ,"+
									"state VARCHAR(20) NOT NULL ,"+
									"pincode INT NOT NULL ,"+
									"dob DATE NOT NULL ,"+
									"mobile INT NOT NULL ,"+
									"email VARCHAR(30) NOT NULL ,"+
									"create_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"+
									"update_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,"+
									"vid INT,"+
									"fid INT)";
				
				System.out.println(stmt.executeUpdate(userTable));
				System.out.println("users table created");				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
