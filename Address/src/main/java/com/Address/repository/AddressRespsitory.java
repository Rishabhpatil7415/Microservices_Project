package com.Address.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Address.model.entity.Address;

public interface AddressRespsitory extends JpaRepository<Address,Long>{

	List<Address> findAllByEmpId(Long empId);

}
