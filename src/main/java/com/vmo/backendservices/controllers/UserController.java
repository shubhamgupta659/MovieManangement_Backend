package com.vmo.backendservices.controllers;

import com.vmo.backendservices.persistance.Domain.UserInfo;
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
    public List<UserInfo> listUser() {
        return userDetailService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserInfo create(@RequestBody UserInfo userInfo) {
        return userDetailService.save(userInfo);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<UserInfo> findOne(@PathVariable Long id) {
        return userDetailService.findOne(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public UserInfo update(@PathVariable Long id, @RequestBody UserInfo userInfo) {
        userInfo.setUserId(id);
        return userDetailService.save(userInfo);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        userDetailService.delete(id);
    }
}
