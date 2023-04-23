package com.tm.nbaapp.controller;

import com.tm.nbaapp.model.ObjRent;
import com.tm.nbaapp.model.User;
import com.tm.nbaapp.service.ObjRentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/objrent")
public class ObjRentController {

    private ObjRentService objRentService;

    public ObjRentController(ObjRentService objRentService) {
        this.objRentService = objRentService;
    }


    @PostMapping("/create")
    public ResponseEntity<ObjRent> create(@RequestBody ObjRent objRent, Principal principal) {
        return new ResponseEntity<ObjRent>(objRentService.save(objRent, principal.getName()), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ObjRent>> getAll() {
        return new ResponseEntity<List<ObjRent>>(objRentService.all(), HttpStatus.OK);

    }
}
