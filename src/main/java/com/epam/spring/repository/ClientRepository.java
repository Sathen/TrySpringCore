package com.epam.spring.repository;

import com.epam.spring.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {


}
