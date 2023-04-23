package com.tm.nbaapp.controller;

import com.tm.nbaapp.model.ObjRent;
import com.tm.nbaapp.model.User;
import com.tm.nbaapp.service.ObjRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.mappers.ModelMapper;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public ResponseEntity<ObjRent> getById(@PathVariable(value = "id") String id) {
        return objRentService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjRent> update(@PathVariable(value = "id") String id, @Valid @RequestBody ObjRent objRent) {
        objRent.setId(Long.valueOf(id));
        objRentService.update(objRent);
        return ResponseEntity.ok(objRent);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<ObjRent>> getByUserId(@PathVariable(value = "id") String id) {
        var listObjRent = objRentService.findByUser(id);
        return ResponseEntity.ok(listObjRent);
    }
}
