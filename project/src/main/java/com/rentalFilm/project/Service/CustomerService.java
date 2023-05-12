package com.rentalFilm.project.Service;

import com.rentalFilm.project.Entities.DTO.CustomerDTO;
import com.rentalFilm.project.Entities.Entity.Customer;
import com.rentalFilm.project.Entities.Entity.Film;
import com.rentalFilm.project.Exceptions.CustomerNotFoundException;
import com.rentalFilm.project.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    List<Customer> customers = new ArrayList<>();


    public Customer GetCustomerById(Long id) throws CustomerNotFoundException {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isEmpty()) throw new CustomerNotFoundException("customer not found");
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        }return null;
    }


        public Customer create (CustomerDTO customer){
            Customer customerDB = new Customer();
            customerDB.setEmail(customer.getEmail());
            customerDB.setFirstName(customer.getFirstName());
            customerDB.setLastName(customer.getLastName());
            return customerRepository.save(customerDB);
        }

        public ResponseEntity deleteCustomer(long id) throws CustomerNotFoundException {
        Customer customerDB = GetCustomerById(id);
        customerRepository.delete(customerDB);
        return ResponseEntity.status(HttpStatus.OK).body("customer deleted " + id);
        }


    public List<Customer> all() throws CustomerNotFoundException {
        customers = customerRepository.findAll();
        customers.stream()
                .findAny()
                .get()
                .toString();

        return customers;
    }

    public List<Customer> deleteAll() throws CustomerNotFoundException {
        customerRepository.deleteAll(customers);
        return null;

    }
}
