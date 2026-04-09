package com.Address.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Address.exception.ResourceNotFoundException;
import com.Address.model.dto.AddressDTO;
import com.Address.model.dto.AddressRequest;
import com.Address.model.dto.AddressRequestDto;
import com.Address.model.entity.Address;
import com.Address.repository.AddressRespsitory;

@Service
public class AddressServiceImpl implements AddressService {
	
   @Autowired	
   private AddressRespsitory addressrepo;
   
   @Autowired
   private ModelMapper modelmapper;
   
   org.slf4j.Logger log =LoggerFactory.getLogger(AddressServiceImpl.class);
   
	@Override
	public List<AddressDTO> saveAddress(AddressRequest addressRequest) {
		//TODO add employee ID to check
		  List<Address> listToSave =this.saveorupdateAddress(addressRequest);
		  return listToSave.stream().map(address ->modelmapper.map(address,AddressDTO.class)).toList();
		}

	@Override
	public List<AddressDTO> updateAddress(AddressRequest addressRequest) {
		// TODO Auto-generated method stub
		
		List<Address> addressByEmpId = addressrepo.findAllByEmpId(addressRequest.getEmpId());
		if(addressByEmpId.isEmpty()) {
			log.info("no address found for employee id {}",addressRequest.getEmpId());
			log.info("Creating new address for employee id {}",addressRequest.getEmpId());
		}
		
		List<Address> listtoUpdate =this.saveorupdateAddress(addressRequest);
		
		//fetched current ids.[1,null]
		List<Long>  upcommingnonNullids = listtoUpdate.stream().map(Address::getId).filter(Objects::nonNull).toList();
		//fetched db ids.[1,2]
		List<Long>  existingIds = addressByEmpId.stream().map(Address::getId).toList();
		//filter out ids which we want to delete
		List<Long> idstoDeleted = existingIds.stream().filter(id ->!upcommingnonNullids.contains(id)).toList();
		
		if(!idstoDeleted.isEmpty()) {
			addressrepo.deleteAllById(idstoDeleted);
		}
		
		List<Address> updatedAddress = addressrepo.saveAll(listtoUpdate);
		return updatedAddress.stream().map(address -> modelmapper.map(address,AddressDTO.class)).toList();
	}

	@Override
	public AddressDTO getSingleAddress(Long id) {
		Address address = addressrepo.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Address not found for this id"+id));
		return modelmapper.map(address, AddressDTO.class);
	}

	@Override
	public List<AddressDTO> getAllAddress() {
		List<Address> address = addressrepo.findAll();
				//.orElseThrow(() ->new ResourceNotFoundException("DB issue Entries not persent for address"));
		if(address.isEmpty()) {
			throw new ResourceNotFoundException("DB issue Entries not persent for address");
		}
		return address.stream().map(addressforemp ->modelmapper.map(addressforemp,AddressDTO.class)).toList();
	}

	@Override
	public void deleteAddress(Long id) {
		Address address = addressrepo.findById(id)
				.orElseThrow(() ->new ResourceNotFoundException("Address not found for this id"+id));
      	addressrepo.deleteById(id);
	}
	

	public List<Address> saveorupdateAddress(AddressRequest addressRequest) {
		//TODO add employee check
		
		List<Address> list = new ArrayList<>();
		for(AddressRequestDto addressreqdto:addressRequest.getAddressRequestDtoList()) {
			Address address = new Address();
			//fetched employee id form AddressRequest
			address.setEmpId(addressRequest.getEmpId());
			address.setPincode(addressreqdto.getPincode());
			address.setStreet(addressreqdto.getStreet());
			address.setId(addressreqdto.getId() != null ? addressreqdto.getId() : null);
			address.setCity(addressreqdto.getCity());
			address.setCountry(addressreqdto.getCountry());
			address.setAddressType(addressreqdto.getAddressType());
			list.add(address);
		}
		       List<Address> saveaddress =  addressrepo.saveAll(list);
		       return  saveaddress;
		}

}
