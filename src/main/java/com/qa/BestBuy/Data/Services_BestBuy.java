package com.qa.BestBuy.Data;

public class Services_BestBuy {
	String HomeDelivery;
	public Services_BestBuy()
	{
		//NewInstance method calls a no-argument Constructor
	}
	public Services_BestBuy(String HomeDelivery){
		this.HomeDelivery=HomeDelivery;
	
	}
	//Getters and Setters
	public String getHomeDelivery() {
		return HomeDelivery;
	}
	public void setHomeDelivery(String homeDelivery) {
		HomeDelivery = homeDelivery;
	}
	

}
