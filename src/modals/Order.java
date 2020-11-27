package modals;

import modals.enums.OrderStatus;

public class Order {

	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	private String id;
	private OrderStatus status;
	private Address deliveryAddress;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", deliveryAddress=" + deliveryAddress + ", user=" + user.getEmail()
				+ "]";
	}
	
}
