package com.cg.evergreenpublications.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.evergreenpublications.entity.CustomerInformation;

@Repository
public interface ListAllCustomersDAO extends JpaRepository<CustomerInformation,Integer>
{
	@Query("SELECT c FROM CustomerInformation c where c.customerId>1 ")
	public Page<CustomerInformation> getAllCustomers(Pageable pageable);

}
