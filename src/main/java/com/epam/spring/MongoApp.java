package com.epam.spring;

import com.epam.spring.bean.Client;
import com.epam.spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MongoApp implements CommandLineRunner {

    @Autowired
    private ClientRepository customerRepository;


    @Override
    public void run(String... args){
        customerRepository.saveAndFlush(new Client("Aleksii"));
       // customerRepository.save(new Client("Aleksii"));
       // customerRepository.save(new Client("Shkot"));

    }
}
