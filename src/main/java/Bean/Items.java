package Bean;

import java.io.Serializable;


public class Items implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String Item_Name;
	protected int item_price;
	protected int item_weight;
	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	protected int item_QTY;
	protected int provider_id;
	protected int category_id;
	protected String descritpion;
	
	public Items() {}
	
	public String getItem_Name() {
		return Item_Name;
	}
	public void setItem_Name(String item_Name) {
		Item_Name = item_Name;
	}
	public int getItem_weight() {
		return item_weight;
	}
	public void setItem_weight(int item_weight) {
		this.item_weight = item_weight;
	}
	public int getItem_QTY() {
		return item_QTY;
	}
	public void setItem_QTY(int item_QTY) {
		this.item_QTY = item_QTY;
	}
	public int getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getDescritpion() {
		return descritpion;
	}
	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}


	

	
	


}
