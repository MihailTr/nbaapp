package com.tm.nbaapp.service;

import com.tm.nbaapp.model.ObjRent;
import com.tm.nbaapp.repository.ObjRentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjRentService {
    private final ObjRentRepository objRentRepository;
    private final UserService userService;

    public ObjRentService(ObjRentRepository objRentRepository, UserService userService) {
        this.objRentRepository = objRentRepository;
        this.userService = userService;
    }

    public List<ObjRent> all() {
        return objRentRepository.findAll();
    }

    public ObjRent save(ObjRent objRent, String username) {
        var user = userService.findUserByUsername(username);
        objRent.setUser(user);
        return objRentRepository.save(objRent);
    }
}
