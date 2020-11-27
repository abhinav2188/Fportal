package modals;

import modals.enums.Unit;

public class ItemCrop {

	public ItemCrop() {
		// TODO Auto-generated constructor stub
	}
	private int quantity;
	private Unit unit;
	private double unitPrice;
	private long expiryTime;
	//minimum selling unit(scale)
	private int unitQuantity;
	private Item item;
	private Crop crop;

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public long getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public int getUnitQuantity() {
		return unitQuantity;
	}
	public void setUnitQuantity(int unitQuantity) {
		this.unitQuantity = unitQuantity;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Crop getCrop() {
		return crop;
	}
	public void setCrop(Crop crop) {
		this.crop = crop;
	}
	@Override
	public String toString() {
		return "ItemCrop [quantity=" + quantity + ", unit=" + unit + ", unitPrice=" + unitPrice + ", expiryTime="
				+ expiryTime + ", unitQuantity=" + unitQuantity + "]";
	}
	
	
}
