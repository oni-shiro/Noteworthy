package com.noteworthy.noteworthybackend.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.ParameterizedType;

@RestController
@RequestMapping(value = "/noteworthy-api")
public class MainController {

    @GetMapping(value = "/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Process is running...");
    }
}
