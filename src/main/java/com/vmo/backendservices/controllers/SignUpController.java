package com.vmo.backendservices.controllers;

import com.vmo.backendservices.persistance.Domain.UserInfo;
import com.vmo.backendservices.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserDetailService userDetailService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserInfo create(@RequestBody UserInfo userInfo) {
        return userDetailService.save(userInfo);
    }

}
