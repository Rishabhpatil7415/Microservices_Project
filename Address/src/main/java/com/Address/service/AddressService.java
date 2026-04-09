package com.Address.service;

import java.util.List;

import com.Address.model.dto.AddressDTO;
import com.Address.model.dto.AddressRequest;

public interface AddressService {
	
	List<AddressDTO> saveAddress(AddressRequest addressRequest);
	
	public List<AddressDTO> updateAddress(AddressRequest addressRequest);
	
    public AddressDTO getSingleAddress(Long id);
    
    public List<AddressDTO> getAllAddress();
    
    public void deleteAddress(Long id);
}
