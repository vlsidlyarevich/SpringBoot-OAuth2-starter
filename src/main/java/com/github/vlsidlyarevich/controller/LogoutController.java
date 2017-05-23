package com.github.vlsidlyarevich.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/logout")
public class LogoutController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> logout() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
