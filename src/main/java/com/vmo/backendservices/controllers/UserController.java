package com.vmo.backendservices.controllers;

import com.vmo.backendservices.persistance.Domain.UserLoginInfo;
import com.vmo.backendservices.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDetailService userDetailService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<UserLoginInfo> listUser() {
        return userDetailService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserLoginInfo create(@RequestBody UserLoginInfo userLoginInfo) {
        return userDetailService.save(userLoginInfo);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<UserLoginInfo> findOne(@PathVariable Long id) {
        return userDetailService.findOne(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public UserLoginInfo update(@PathVariable Long id, @RequestBody UserLoginInfo userLoginInfo) {
        userLoginInfo.setUserId(id);
        return userDetailService.save(userLoginInfo);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        userDetailService.delete(id);
    }
}
