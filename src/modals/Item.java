package modals;

import modals.enums.ItemStatus;
import modals.enums.ItemType;

public class Item {

	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	private String id;
	private String pickupAddress;
	private ItemType type;
	private ItemStatus status;
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
	public String getPickupAddress() {
		return pickupAddress;
	}
	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
	public ItemStatus getStatus() {
		return status;
	}
	public void setStatus(ItemStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", pickupAddress=" + pickupAddress + ", type=" + type + ", status=" + status
				+ ", user=" + user.getId() + "]";
	}

}
