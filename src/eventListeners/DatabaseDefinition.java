package eventListeners;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			
			DatabaseMetaData dbmd = conn.getMetaData();
			String []types = {"TABLE"};
			ResultSet rs = dbmd.getTables("fPortal",null,"%",types);
			List<String> tables = new ArrayList<String>();			

			boolean flag = true;			
			while(rs.next()) {
				flag = false;
					String t = rs.getString(3);
					System.out.println(t);
					tables.add(t);
			}
			if(flag) {
				clearDatabase(conn,tables);
				createDatabase(conn);				
			}
			
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
	private void clearDatabase(Connection conn,List<String> tables) {
		try {
			Statement stmt = conn.createStatement() ;
			
			if(tables.contains("order_item")) {
				stmt.executeUpdate("Alter table order_item drop constraint if exists orderItemFK");
				stmt.executeUpdate("Alter table order_item drop constraint if exists itemOrderFK");
				stmt.executeUpdate("Delete from order_item");
				stmt.executeUpdate("Drop table if exists order_item");
				System.out.println("order_item table dropped");				
				
			}
			if(tables.contains("orders")) {
				stmt.executeUpdate("Alter table orders drop constraint if exists orderUserFK");
				stmt.executeUpdate("Delete from orders");
				stmt.executeUpdate("Drop table if exists orders");
				System.out.println("orders table dropped");				
				
			}

			if(tables.contains("item_crop")) {
				stmt.executeUpdate("Alter table item_crop drop constraint if exists itemCropFK");
				stmt.executeUpdate("Alter table item_crop drop constraint if exists cropItemFK");
				stmt.executeUpdate("Delete from item_crop");
				stmt.executeUpdate("Drop table if exists item_crop");
				System.out.println("item_crop table dropped");				
			}
			if(tables.contains("items")) {
				stmt.executeUpdate("Alter table items drop constraint if exists itemFarmerFK");
				stmt.executeUpdate("Alter table items drop constraint if exists userAddressFK");
				stmt.executeUpdate("Delete from items");
				stmt.executeUpdate("Drop table if exists items");
				System.out.println("items table dropped");
			}
			if(tables.contains("crops")) {
				stmt.executeUpdate("Delete from crops");
				stmt.executeUpdate("Drop table if exists crops");
				System.out.println("crops table dropped");
			}
			if(tables.contains("address")) {
				stmt.executeUpdate("Alter table users drop constraint if exists userAddressFK");				
				stmt.executeUpdate("Alter table address drop constraint if exists addressUserFK");
				stmt.executeUpdate("Delete from address");
				stmt.executeUpdate("Drop table if exists address");				
				System.out.println("address table dropped");
			}
			if(tables.contains("farmers")) {
				stmt.executeUpdate("Alter table users drop constraint if exists userFarmerFK");
				stmt.executeUpdate("Alter table farmers drop constraint if exists farmerUserFK");
				stmt.executeUpdate("Delete from farmers");
				stmt.executeUpdate("Drop table if exists farmers");				
				System.out.println("farmers table dropped");
			}
			if(tables.contains("users")) {
				stmt.executeUpdate("Delete from users");
				stmt.executeUpdate("Drop table if exists users");
				System.out.println("users table dropped");				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createDatabase(Connection conn) {
		
		try {
			
			Statement stmt = conn.createStatement();
			
			String userTable = "create table users (" 
					+"uid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, "
					+"first_name VARCHAR(20) NOT NULL ,"
					+"last_name VARCHAR(20), "
					+"mobile INT NOT NULL UNIQUE,"
					+"email VARCHAR(30) NOT NULL UNIQUE ,"
					+"password varchar(30) NOT NULL,"
					+"create_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
					+"update_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,"
					+"fid INT unsigned ,"
					+"permanant_address int unsigned ,"
					+ "is_seller bit default 0"
					+ ")";
			
			String farmerTable = "create table farmers ("
					+"fid INT UNSIGNED AUTO_INCREMENT PRIMARY KEY not null, "
					+ "dob DATE NOT NULL,"
					+ "ratings INT ,"
					+ "revenue DOUBLE(12,4) ,"
					+ "uid INT UNSIGNED NOT NULL"
					+ ");";

			String addressTable = "create table address ("
					+ "aid INT Unsigned auto_increment primary key,"
					+ "city varchar(30) not null,"
					+ "state varchar(30) not null,"
					+ "pincode varchar(10) not null,"
					+ "full_address varchar(50) not null,"
					+ "country varchar(30) not null,"
					+ "contact int not null,"
					+ "name varchar(30) not null,"
					+ "uid int unsigned not null"
					+ ")";
			
			String cropTable = "create table crops ("
					+ "cid int unsigned auto_increment primary key,"
					+ "name varchar(30) not null,"
					+ "description varchar(100) ,"
					+ "best_before_time long"
					+ ")";
			
	
			String itemsTable = "create table items("
					+ "id int unsigned auto_increment primary key,"
					+ "item_type varchar(30) not null,"
					+ "item_status varchar(30) not null,"
					+ "pickup_address int unsigned ,"
					+ "fid int unsigned not null"
					+ ")";
			
			String itemCropTable = "create table item_crop("
					+ "qunatity int not null,"
					+ "unit varchar(30) not null,"
					+ "unit_price double(10,4) not null,"
					+ "expiry_time long ,"
					+ "unit_qunatity int not null default 1,"
					+ "item_id int unsigned not null,"
					+ "crop_id int unsigned not null,"
					+ "primary key(item_id, crop_id)"
					+ ")";
			
			String ordersTable = "create table orders("
					+ "id int unsigned auto_increment primary key,"
					+ "order_status varchar(30) not null,"
					+ "delivery_address int unsigned not null,"
					+ "uid int unsigned not null"
					+ ")";
			
			String orderItemTable = "create table order_item("
					+ "order_id int unsigned not null,"
					+ "item_id int unsigned not null,"
					+ "number_of_units int not null,"
					+ "price double not null"
					+ ")";
				
									
			stmt.executeUpdate(userTable);
			System.out.println(userTable);
			stmt.executeUpdate(addressTable);
			System.out.println(addressTable);
			stmt.executeUpdate(farmerTable);
			System.out.println(farmerTable);
			stmt.executeUpdate(cropTable);
			System.out.println(cropTable);
			stmt.executeUpdate(itemsTable);
			System.out.println(itemsTable);
			stmt.executeUpdate(itemCropTable);
			System.out.println(itemCropTable);
			stmt.executeUpdate(ordersTable);
			System.out.println(ordersTable);
			stmt.executeUpdate(orderItemTable);
			System.out.println(orderItemTable);
			

			String fuFK = "alter table farmers add CONSTRAINT farmerUserFK Foreign key(uid) References users(uid) on delete cascade on update cascade";
			String ufFK = "alter table users add constraint userFarmerFK foreign key(fid) references farmers(fid) on delete set null on update cascade ";				
			String auFK = "alter table address add CONSTRAINT addressUserFK Foreign key(uid) References users(uid) on delete cascade on update cascade";
			String uaFK = "alter table users add constraint userAddressFK foreign key(permanant_address) references address(aid) on delete set null";
			String itemAddressFK = "alter table items add constraint itemAddressFK foreign key(pickup_address) references address(aid) on delete set null";
			String itemFarmerFK = "alter table items add constraint itemFarmerFK foreign key(fid) references farmers(uid) on delete cascade on update cascade";
			String itemCropFK = "alter table item_crop add constraint itemCropFK foreign key(item_id) references items(id) on delete cascade on update cascade";
			String cropItemFK = "alter table item_crop add constraint cropItemFK foreign key(crop_id) references crops(cid) on delete cascade on update cascade";
			String orderUserFK ="alter table orders add constraint orderUserFK foreign key(uid) references users(uid) on delete cascade on update cascade";
			String orderItemFK = "alter table order_item add constraint orderItemFK foreign key(item_id) references items(id) on delete cascade on update cascade";
			String itemOrderFK = "alter table order_item add constraint itemOrderFK foreign key(order_id) references orders(id) on delete cascade on update cascade";

			stmt.executeUpdate(ufFK);
			System.out.println(ufFK);
			stmt.executeUpdate(uaFK);
			System.out.println(uaFK);
			stmt.executeUpdate(fuFK);
			System.out.println(fuFK);
			stmt.executeUpdate(auFK);
			System.out.println(auFK);
			stmt.executeUpdate(itemAddressFK);
			System.out.println(itemAddressFK);
			stmt.executeUpdate(itemFarmerFK);
			System.out.println(itemFarmerFK);
			stmt.executeUpdate(itemCropFK);
			System.out.println(itemCropFK);
			stmt.executeUpdate(cropItemFK);
			System.out.println(cropItemFK);
			stmt.executeUpdate(orderUserFK);
			System.out.println(orderUserFK);
			stmt.executeUpdate(orderItemFK);
			System.out.println(orderItemFK);
			stmt.executeUpdate(itemOrderFK);
			System.out.println(itemOrderFK);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
