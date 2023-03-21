package Bean;

import java.io.Serializable;

public class category implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int category_id;
	protected String category_name;
	protected String Category_description;
	
	public category() {}

	
	public String getCategory_description() {
		return Category_description;
	}

	public void setCategory_description(String category_description) {
		Category_description = category_description;
	}

	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public String getCategory_name() {
		return category_name;
	}
	
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	

}
