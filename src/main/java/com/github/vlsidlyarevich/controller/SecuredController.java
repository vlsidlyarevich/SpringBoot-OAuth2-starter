package com.github.vlsidlyarevich.controller;

import com.github.vlsidlyarevich.security.facade.SecurityContextAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/user")
public class SecuredController {

    private final SecurityContextAuthenticationFacade facade;

    @Autowired
    public SecuredController(final SecurityContextAuthenticationFacade facade) {
        this.facade = facade;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity<>(facade.getAuthentication(), HttpStatus.OK);
    }
}
