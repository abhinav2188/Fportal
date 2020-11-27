package modals;

public class OrderItem {

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	
	private Order order;
	private Item item;
	private int numberOfUnits;
	private double price;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getNumberOfUnits() {
		return numberOfUnits;
	}
	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderItem [order=" + order.getId() + ", item=" + item.getId() + ", numberOfUnits=" + numberOfUnits + ", price=" + price
				+ "]";
	}
	
	

}
