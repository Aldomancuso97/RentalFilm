package com.rentalFilm.project.Controller;

import com.rentalFilm.project.Exceptions.CustomerNotFoundException;
import com.rentalFilm.project.Repositories.CustomerRepository;
import com.rentalFilm.project.Service.CustomerService;
import jakarta.persistence.GeneratedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @GetMapping("/{Id}")
    public ResponseEntity getCustomerByID(@PathVariable Long Id){
        try{
            logger.info("try to find a customer by ID" + Id);
            return ResponseEntity.status(HttpStatus.OK).body(customerService.GetCustomerById(Id));
        }catch (CustomerNotFoundException e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }


}
