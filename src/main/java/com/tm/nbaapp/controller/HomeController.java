package com.tm.nbaapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")
    public String testHome(){
        return "Home" ;
    }

}
