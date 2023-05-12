package com.rentalFilm.project.Service;

import com.rentalFilm.project.Entities.DTO.StaffDTO;
import com.rentalFilm.project.Entities.DTO.StoreDTO;
import com.rentalFilm.project.Entities.Entity.Staff;
import com.rentalFilm.project.Entities.Entity.Store;
import com.rentalFilm.project.Exceptions.StaffNotFoundException;
import com.rentalFilm.project.Exceptions.StoreNotFoundException;
import com.rentalFilm.project.Repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    StoreRepository storeRepository;

    List<Store> storeList = new ArrayList<>();


    public Store GetStoreById(Long id) throws StoreNotFoundException {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if (storeOptional.isEmpty()) throw new StoreNotFoundException("store not found");
        if (storeOptional.isPresent()) {
            return storeOptional.get();
        }return null;
    }


    public Store create (StoreDTO storeDTO){
        Store storeDB = new Store();
        storeDB.setStore_name(storeDB.getStore_name());
        return storeRepository.save(storeDB);
    }

    public ResponseEntity deleteStaff(long id) throws  StoreNotFoundException {
        Store storeDB = GetStoreById(id);
        storeRepository.delete(storeDB);
        return ResponseEntity.status(HttpStatus.OK).body("store deleted " + id);
    }


    public List<Store> all() throws StoreNotFoundException {
        storeList = storeRepository.findAll();
        storeList.stream()
                .findAny()
                .get()
                .toString();

        return storeList;
    }

    public List<Store> deleteAll() throws StoreNotFoundException {
        storeRepository.deleteAll(storeList);
        return null;

    }
}
