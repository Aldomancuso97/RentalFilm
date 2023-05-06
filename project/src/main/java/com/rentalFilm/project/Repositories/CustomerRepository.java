package com.rentalFilm.project.Repositories;

import com.rentalFilm.project.Entities.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
