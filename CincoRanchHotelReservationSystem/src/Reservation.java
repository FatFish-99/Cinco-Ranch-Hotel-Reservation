
public class Reservation {
	public Reservation(String id, String name, int nights, int rate) {
		super();
		this.id = id;
		this.name = name;
		this.nights = nights;
		this.rate = rate;
	}
	private String id, name;
	private int nights, rate;
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
	public int getNights() {
		return nights;
	}
	public void setNights(int nights) {
		this.nights = nights;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return id + " " + name + " " + nights + " " + rate;
	}
}

