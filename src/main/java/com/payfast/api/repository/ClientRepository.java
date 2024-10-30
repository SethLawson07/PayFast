package com.payfast.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payfast.api.models.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client> findByLastNameAndFirstName(String lastName,String firstName);
    
}
