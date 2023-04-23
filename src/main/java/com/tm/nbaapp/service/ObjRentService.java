package com.tm.nbaapp.service;

import com.tm.nbaapp.model.ObjRent;
import com.tm.nbaapp.model.Role;
import com.tm.nbaapp.model.User;
import com.tm.nbaapp.repository.ObjRentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ObjRentService {
    private final ObjRentRepository objRentRepository;

    public ObjRentService(ObjRentRepository objRentRepository) {
        this.objRentRepository = objRentRepository;
    }

    public List<ObjRent> all() {
        return objRentRepository.findAll();
    }

    public ObjRent save(ObjRent objRent) {
        return objRentRepository.save(objRent);
//
//        user.setRoles(Collections.singleton(new Role(2L, "USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        var newUser = userRepository.save(user);
//        return newUser;
    }



}
