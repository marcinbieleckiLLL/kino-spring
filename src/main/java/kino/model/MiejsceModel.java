package kino.model;

public class MiejsceModel {

	private String rzad;
	private String miejsce;
	
	public MiejsceModel(){};
	
	public MiejsceModel(String rzad, String miejsce) {
		super();
		this.rzad = rzad;
		this.miejsce = miejsce;
	}

	public String getRzad() {
		return rzad;
	}

	public void setRzad(String rzad) {
		this.rzad = rzad;
	}

	public String getMiejsce() {
		return miejsce;
	}

	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}
	
	
}
