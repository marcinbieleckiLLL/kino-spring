package kino.model;

public class BasketItemModel {

	private Long id;

	public BasketItemModel(Long id) {
		super();
		this.id = id;
	}

	public BasketItemModel() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
