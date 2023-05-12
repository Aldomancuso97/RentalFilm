package com.rentalFilm.project.Controller;

import com.rentalFilm.project.Entities.DTO.RoleDTO;
import com.rentalFilm.project.Entities.Entity.Role;
import com.rentalFilm.project.Exceptions.CustomerNotFoundException;
import com.rentalFilm.project.Exceptions.RoleNotFoundException;
import com.rentalFilm.project.Repositories.RoleRepository;
import com.rentalFilm.project.Service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    RoleService roleService;

    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @PostMapping("/create")
    public ResponseEntity createRole(@RequestBody RoleDTO roleDTO){
        logger.info("try to create a role");
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(roleDTO));
    }


    @GetMapping("/{id}")
    public ResponseEntity ReadRole(@PathVariable long id){
        try {
            logger.info("try to find a role " + id);
            return ResponseEntity.status(HttpStatus.OK).body(roleService.readRole(id));
        } catch (RoleNotFoundException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage() + "role not found " + id);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRole(@PathVariable long id){
        try {
            logger.info("try to delete role " + id);
            return ResponseEntity.status(HttpStatus.OK).body(roleService.deleteRole(id));
        } catch (RoleNotFoundException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity readAll(){
        try{
            logger.info("try to read list of rules");
            return ResponseEntity.status(HttpStatus.OK).body(roleService.readAll());
        }catch (RoleNotFoundException e){
            logger.warn(e.getMessage());
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    @DeleteMapping("/all")
    public ResponseEntity deleteAll(){
        try {
            logger.info("try to delete all roles");
            roleService.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).body("all rules deleted ");
        } catch (CustomerNotFoundException e) {
            logger.warn(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }























}
