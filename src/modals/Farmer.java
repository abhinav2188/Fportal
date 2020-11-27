package modals;

import java.sql.Date;
import java.util.List;

public class Farmer {

	public Farmer() {
		super();
	}
	private String id;
	private int ratings;
	private double revenue;
	private Date dob;
	private List<Item> items;
	private User user;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public double getRevenue() {
		return revenue;
	}
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Farmer [id=" + id + ", ratings=" + ratings + ", revenue=" + revenue + ", dob=" + dob + ", items="
				+ items + ", user=" + user.getId() + "]";
	}
	
	

}
