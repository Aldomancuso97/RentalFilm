package com.rentalFilm.project.Controller;

import com.rentalFilm.project.Entities.DTO.StoreDTO;
import com.rentalFilm.project.Exceptions.StaffNotFoundException;
import com.rentalFilm.project.Exceptions.StoreNotFoundException;
import com.rentalFilm.project.Service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

        @Autowired
        StoreService storeService;
        private final Logger logger = LoggerFactory.getLogger(StoreController.class);


        @PostMapping("/create")
        public ResponseEntity createStore(@RequestBody StoreDTO storeDTO) {
            try {
                logger.info("try to create a store");
                return ResponseEntity.status(HttpStatus.OK).body(storeService.create(storeDTO));
            } catch (Exception e) {
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            }

        }


        @GetMapping("/{id}")
        public ResponseEntity getStoreByID(@PathVariable Long id) {
            try {
                logger.info("try to find a store by ID" + id);
                return ResponseEntity.status(HttpStatus.OK).body(storeService.GetStoreById(id));
            } catch (StoreNotFoundException e) {
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity deleteStore(@PathVariable long id) {
            try {
                logger.info("try to delete store by id " + id);
                return ResponseEntity.status(HttpStatus.OK).body(storeService.deleteStaff(id));
            } catch (StoreNotFoundException e) {
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }

        }

        @GetMapping("/all")
        public ResponseEntity allStore() {
            try {
                logger.info("try to show all stores");
                return ResponseEntity.status(HttpStatus.OK).body(storeService.all());
            } catch (StoreNotFoundException e) {
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }

        }

        @DeleteMapping("/all")
        public ResponseEntity deleteAll() {
            try {
                logger.info("try to delete all stores");
                storeService.deleteAll();
                return ResponseEntity.status(HttpStatus.OK).body("all store deleted ");
            } catch (StoreNotFoundException e) {
                logger.warn(e.getMessage());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
        }

    }

