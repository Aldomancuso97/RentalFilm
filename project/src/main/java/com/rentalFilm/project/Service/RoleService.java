package com.rentalFilm.project.Service;

import com.rentalFilm.project.Entities.DTO.RoleDTO;
import com.rentalFilm.project.Entities.Entity.Customer;
import com.rentalFilm.project.Entities.Entity.Role;
import com.rentalFilm.project.Exceptions.CustomerNotFoundException;
import com.rentalFilm.project.Exceptions.RoleNotFoundException;
import com.rentalFilm.project.Repositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    RoleRepository roleRepository;

    List<Role> roleList = new ArrayList<>();

    public Role create(RoleDTO roleDTO) {
        Role role = new Role();
        role.setRoleName(roleDTO.getRoleName());
        roleRepository.save(role);
        return role;
    }

    public Role readRole(long id) throws RoleNotFoundException {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if (optionalRole.isEmpty()) throw new RoleNotFoundException("Role not found");
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        }
        return null;
    }

    public Role deleteRole(long id) throws RoleNotFoundException {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isPresent()){
            roleRepository.deleteById(optionalRole.get().getID());
        }return null;
    }

    public List<Role> readAll() throws RoleNotFoundException {
        roleList = roleRepository.findAll();
        roleList.stream()
                .findAny()
                .get()
                .toString();

        return roleList;
    }

    public List<Role> deleteAll() throws CustomerNotFoundException {
        roleRepository.deleteAll(roleList);
        return null;

    }
}

