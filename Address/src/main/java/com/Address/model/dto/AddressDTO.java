package com.Address.model.dto;

import com.Address.model.enums.AddressType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class AddressDTO {

	private Long id;
	private Long empId;
	private String street;
	private Long pincode;
	private String city;
	private String country;
	
	@Enumerated(EnumType.STRING)
	private AddressType addressType;

	
	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AddressDTO(Long id, Long empId, String street, Long pincode, String city, String country,
			AddressType addressType) {
		super();
		this.id = id;
		this.empId = empId;
		this.street = street;
		this.pincode = pincode;
		this.city = city;
		this.country = country;
		this.addressType = addressType;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public Long getPincode() {
		return pincode;
	}


	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public AddressType getAddressType() {
		return addressType;
	}


	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}


	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", empId=" + empId + ", street=" + street + ", pincode=" + pincode + ", city="
				+ city + ", country=" + country + ", addressType=" + addressType + "]";
	}

	
}
