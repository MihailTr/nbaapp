package com.tm.nbaapp.service;

import com.tm.nbaapp.model.ObjRent;
import com.tm.nbaapp.repository.ObjRentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<ObjRent> findById(String id) {
        return objRentRepository.findById(Long.valueOf(Integer.parseInt(id)));
    }

    public ObjRent update(ObjRent objRent) {

        objRentRepository.save(objRent);
        return objRent;
    }

    public List<ObjRent> findByUser(String id) {
        return objRentRepository.findByUserId(Long.valueOf(Integer.parseInt(id)));
    }
}
