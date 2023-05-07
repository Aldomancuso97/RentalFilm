package com.rentalFilm.project.Controller;

import com.rentalFilm.project.Entities.DTO.CustomerDTO;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @PostMapping("/create")
    public ResponseEntity createCustomer(@RequestBody CustomerDTO customerDTO){
        try{
            logger.info("try to create a customer");
            return ResponseEntity.status(HttpStatus.OK).body(customerService.create(customerDTO));
        }catch (Exception e){
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }


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
