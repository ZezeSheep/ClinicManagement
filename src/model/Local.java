package model;

public class Local {
	private String street;
	private String district;
	private String number;
	private String cep;
	private String city;
	private String state;
	
	public Local(String street, String district, String number, String cep, String city, String state) {
		this.street = street;
		this.district = district;
		this.number = number;
		this.cep = cep;
		this.city = city;
		this.state = state;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
