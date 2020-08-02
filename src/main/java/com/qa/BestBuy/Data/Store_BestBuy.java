package com.qa.BestBuy.Data;



//Plain old Java Object
public class Store_BestBuy {
	
    String name;
	String type;
	String address;
	String address2;
	String city;
	String state;
	String zip;
	long   lat;
	long   lng;
	String hours;
	Services_BestBuy services;
	
	public Store_BestBuy(String name, String type, String address, String address2, String city, 
			String state, String zip, long lat, long lng, String hours, Services_BestBuy services)
	{
	  this.name=name;
	  this.type=type;
	  this.address=address;
	  this.address2=address2;
	  this.city=city;
	  this.state=state;
	  this.zip=zip;
	  this.lat=lat;
	  this.lng=lng;
	  this.hours=hours;
	  this.services=services;
	  
	}
	//getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public long getLat() {
		return lat;
	}

	public void setLat(long lat) {
		this.lat = lat;
	}

	public long getLng() {
		return lng;
	}

	public void setLng(long lng) {
		this.lng = lng;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public Services_BestBuy getServices() {
		return services;
	}

	public void setServices(Services_BestBuy services) {
		this.services = services;
	}

	

	

	
	
	
	
}
