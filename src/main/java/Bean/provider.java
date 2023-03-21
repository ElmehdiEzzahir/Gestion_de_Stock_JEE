package Bean;

import java.io.Serializable;

public class provider implements Serializable {
	private static final long serialVersionUID = 1L;
	protected int provider_id;
	protected String  provider_name;
	protected int provider_age;
	protected String provider_address;
	protected String company_name;
	
	public provider() {}

	
	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public int getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}

	public String getProvider_name() {
		return provider_name;
	}

	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}

	public int getProvider_age() {
		return provider_age;
	}

	public void setProvider_age(int provider_age) {
		this.provider_age = provider_age;
	}

	public String getProvider_address() {
		return provider_address;
	}

	public void setProvider_address(String provider_address) {
		this.provider_address = provider_address;
	}
	
	


}
