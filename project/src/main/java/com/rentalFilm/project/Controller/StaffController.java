package com.rentalFilm.project.Controller;

import com.rentalFilm.project.Entities.DTO.CustomerDTO;
import com.rentalFilm.project.Entities.DTO.StaffDTO;
import com.rentalFilm.project.Exceptions.CustomerNotFoundException;
import com.rentalFilm.project.Exceptions.StaffNotFoundException;
import com.rentalFilm.project.Service.CustomerService;
import com.rentalFilm.project.Service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
public class StaffController {

        @Autowired
        StaffService staffService;
        private final Logger logger = LoggerFactory.getLogger(StaffController.class);


        @PostMapping("/create")
        public ResponseEntity createStaff(@RequestBody StaffDTO staffDTO){
            try{
                logger.info("try to create a staff");
                return ResponseEntity.status(HttpStatus.OK).body(staffService.create(staffDTO));
            }catch (Exception e){
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }

        }


        @GetMapping("/{id}")
        public ResponseEntity getStaffByID(@PathVariable Long id){
            try{
                logger.info("try to find a staff by ID" + id);
                return ResponseEntity.status(HttpStatus.OK).body(staffService.GetStaffById(id));
            }catch (StaffNotFoundException e){
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity deleteStaff(@PathVariable long id){
            try{
                logger.info("try to delete staff by id " + id);
                return ResponseEntity.status(HttpStatus.OK).body(staffService.deleteStaff(id));
            } catch (StaffNotFoundException e) {
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }

        }

        @GetMapping("/all")
        public  ResponseEntity allStaff(){
            try {
                logger.info("try to show all staff");
                return ResponseEntity.status(HttpStatus.OK).body(staffService.all());
            } catch (StaffNotFoundException e) {
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }

        }

        @DeleteMapping("/all")
        public ResponseEntity deleteAll(){
            try {
                logger.info("try to delete all staff");
                staffService.deleteAll();
                return ResponseEntity.status(HttpStatus.OK).body("all staff deleted ");
            } catch (StaffNotFoundException e) {
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
        }


    }


