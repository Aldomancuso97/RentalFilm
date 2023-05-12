package com.rentalFilm.project.Service;

import com.rentalFilm.project.Entities.DTO.CustomerDTO;
import com.rentalFilm.project.Entities.DTO.StaffDTO;
import com.rentalFilm.project.Entities.Entity.Customer;
import com.rentalFilm.project.Entities.Entity.Staff;
import com.rentalFilm.project.Exceptions.CustomerNotFoundException;
import com.rentalFilm.project.Exceptions.StaffNotFoundException;
import com.rentalFilm.project.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    List<Staff> staffList = new ArrayList<>();


    public Staff GetStaffById(Long id) throws StaffNotFoundException {
        Optional<Staff> staffOptional = staffRepository.findById(id);
        if (staffOptional.isEmpty()) throw new StaffNotFoundException("staff not found");
        if (staffOptional.isPresent()) {
            return staffOptional.get();
        }return null;
    }


    public Staff create (StaffDTO staffDTO){
        Staff staffDB = new Staff();
        staffDB.setFirstname(staffDB.getFirstname());
        staffDB.setLastname(staffDB.getLastname());
        staffDB.setDate(staffDB.getDate());
        return staffRepository.save(staffDB);
    }

    public ResponseEntity deleteStaff(long id) throws  StaffNotFoundException {
        Staff staffDB = GetStaffById(id);
        staffRepository.delete(staffDB);
        return ResponseEntity.status(HttpStatus.OK).body("staff deleted " + id);
    }


    public List<Staff> all() throws StaffNotFoundException {
        staffList = staffRepository.findAll();
        staffList.stream()
                .findAny()
                .get()
                .toString();

        return staffList;
    }

    public List<Staff> deleteAll() throws StaffNotFoundException {
        staffRepository.deleteAll(staffList);
        return null;

    }
}
