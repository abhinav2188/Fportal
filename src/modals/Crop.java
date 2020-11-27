package modals;

public class Crop {

	public Crop() {
		// TODO Auto-generated constructor stub
	}

	private String id;
	private String name;
	private String description;
	private long bestBeforeTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getBestBeforeTime() {
		return bestBeforeTime;
	}
	public void setBestBeforeTime(long bestBeforeTime) {
		this.bestBeforeTime = bestBeforeTime;
	}
	@Override
	public String toString() {
		return "Crop [id=" + id + ", name=" + name + ", description=" + description + ", bestBeforeTime="
				+ bestBeforeTime + "]";
	}
	
	
	
}
