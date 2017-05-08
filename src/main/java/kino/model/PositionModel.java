package kino.model;

public class PositionModel {

	private String raw;
	private String place;
	
	public PositionModel(){};
	
	public PositionModel(String raw, String place) {
		super();
		this.raw = raw;
		this.place = place;
	}

	public String getRaw() {
		return raw;
	}

	public void setRaw(String raw) {
		this.raw = raw;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	
}
