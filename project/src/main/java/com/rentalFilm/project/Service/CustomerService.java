package com.rentalFilm.project.Service;

import com.rentalFilm.project.Entities.DTO.CustomerDTO;
import com.rentalFilm.project.Entities.Entity.Customer;
import com.rentalFilm.project.Exceptions.CustomerNotFoundException;
import com.rentalFilm.project.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Customer GetCustomerById(Long id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        }
        return null;


    }

    public Customer create(CustomerDTO customer) {
         Customer customerDB = new Customer();
       return customerRepository.save(customerDB);
    }


}

