package com.iit.bean;

import java.io.Serializable;

public class Order {
	private String orderid;
	private String userid;
	private String username;
	private String email;
	private String creditcard;
	private String deliverydate;
	private String deliverytype;
	private Integer orderquantity;
	private Integer pickupstore;
	private String state;
	private String city;
	private String street;
	private String mobile;
	private String address;
	private String zipcode;
	private long shipdate;
	private long createtime;
	private Double totalamount;
	private Double shipcost;

	public Order() {
	}

	public Order(String orderid, String userid, String username, String email, String creditcard, String deliverydate, String deliverytype, Integer orderquantity, Integer pickupstore, String state, String city, String street, String mobile, String address, String zipcode, long shipdate, long createtime, Double totalamount, Double shipcost) {
		this.orderid = orderid;
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.creditcard = creditcard;
		this.deliverydate = deliverydate;
		this.deliverytype = deliverytype;
		this.orderquantity = orderquantity;
		this.pickupstore = pickupstore;
		this.state = state;
		this.city = city;
		this.street = street;
		this.mobile = mobile;
		this.address = address;
		this.zipcode = zipcode;
		this.shipdate = shipdate;
		this.createtime = createtime;
		this.totalamount = totalamount;
		this.shipcost = shipcost;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype;
	}

	public Integer getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(Integer orderquantity) {
		this.orderquantity = orderquantity;
	}

	public Integer getPickupstore() {
		return pickupstore;
	}

	public void setPickupstore(Integer pickupstore) {
		this.pickupstore = pickupstore;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public long getShipdate() {
		return shipdate;
	}

	public void setShipdate(long shipdate) {
		this.shipdate = shipdate;
	}

	public long getCreatetime() {
		return createtime;
	}

	public void setCreatetime(long createtime) {
		this.createtime = createtime;
	}

	public Double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}

	public Double getShipcost() {
		return shipcost;
	}

	public void setShipcost(Double shipcost) {
		this.shipcost = shipcost;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderid='" + orderid + '\'' +
				", userid='" + userid + '\'' +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", creditcard='" + creditcard + '\'' +
				", deliverydate='" + deliverydate + '\'' +
				", deliverytype='" + deliverytype + '\'' +
				", orderquantity=" + orderquantity +
				", pickupstore=" + pickupstore +
				", state='" + state + '\'' +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", mobile='" + mobile + '\'' +
				", address='" + address + '\'' +
				", zipcode='" + zipcode + '\'' +
				", shipdate=" + shipdate +
				", createtime=" + createtime +
				", totalamount=" + totalamount +
				", shipcost=" + shipcost +
				'}';
	}
}
