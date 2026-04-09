package com.Address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Address.model.dto.AddressDTO;
import com.Address.model.dto.AddressRequest;
import com.Address.service.AddressService;

@RestController
@RequestMapping("address")
public class AddressController {

	@Autowired
	private AddressService addressservice;
	
    @PostMapping("/save")
    public ResponseEntity<List<AddressDTO>> saveEmployee(@RequestBody AddressRequest addressreq){
      List<AddressDTO> addressdto = addressservice.saveAddress(addressreq);
      return new ResponseEntity<>(addressdto,HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<List<AddressDTO>> updateEmployee(@RequestBody AddressRequest addressreq){
    	List<AddressDTO> updatelist = addressservice.updateAddress(addressreq);
    	return new ResponseEntity<>(updatelist,HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id){
    	AddressDTO singleAddress = addressservice.getSingleAddress(id);
    	return new ResponseEntity<>(singleAddress,HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<AddressDTO>> getAddressById(){
    	List<AddressDTO> listAddress = addressservice.getAllAddress();
    	return new ResponseEntity<>(listAddress,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id){
    	   addressservice.deleteAddress(id);
    return new ResponseEntity<>("Address deleted successfully",HttpStatus.OK); 
    }
}
