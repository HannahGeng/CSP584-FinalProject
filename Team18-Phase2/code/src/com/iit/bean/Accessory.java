package com.iit.bean;

import java.io.Serializable;

public class Accessory extends Product implements Serializable {
	private int productid;
	private String model;
	private double price;
	private String image;
	private String manufacturer;
	private String type;

	public Accessory() {
	}

	public Accessory(int productid, String model, double price, String image, String manufacturer, String type) {
		this.productid = productid;
		this.model = model;
		this.price = price;
		this.image = image;
		this.manufacturer = manufacturer;
		this.type = type;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
