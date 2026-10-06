package org.spring.day11springbootinterceptors.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")

public class Controller {

    @PostMapping
    public ResponseEntity<String> createStudent(){
        System.out.println("controller Called");

        return ResponseEntity.ok("Student Created");
    }
}
