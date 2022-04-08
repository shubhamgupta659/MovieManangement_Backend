package com.vmo.backendservices.service;

import com.vmo.backendservices.dto.AddressDTO;
import com.vmo.backendservices.dto.UserDTO;
import com.vmo.backendservices.persistance.Domain.Address;
import com.vmo.backendservices.persistance.Domain.UserInfo;
import com.vmo.backendservices.persistance.Domain.RoleInfo;
import com.vmo.backendservices.persistance.Repository.UserRepository;
import com.vmo.backendservices.persistance.Repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Transactional
@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService, UserDetailService {

    @Autowired
    UserRolesRepository rolesRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByUserName(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("User Not Followed");
        }
        return new UserPrincipalService(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {

        return userRepository.findAll();
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        UserInfo loginInfo = userRepository.save(userInfo);
        RoleInfo roles = new RoleInfo();
        roles.setRoleId(3L);
        roles.setRoleName("USER");
        //rolesRepository.save(roles);
        Set<RoleInfo> roleInfoSet = new HashSet<>();
        roleInfoSet.add(roles);
        loginInfo.setRolesInfo(roleInfoSet);
        return loginInfo;

    }

    @Override
    public Optional<UserInfo> findOne(Long id) {

        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserInfo saveNewUser(UserDTO userInfo) {
        UserInfo newUserInfo = new UserInfo();
        newUserInfo.setFirstName(userInfo.getFirstName());
        newUserInfo.setLastName(userInfo.getLastName());
        newUserInfo.setUserName(userInfo.getUserName());
        newUserInfo.setPhone(userInfo.getPhone());
        newUserInfo.setNotification(userInfo.getNotification());
        newUserInfo.setEmail(userInfo.getEmailGroup().getEmail());
        newUserInfo.setPassword(userInfo.getPasswordGroup().getPassword());
        newUserInfo.setSendCatalog(userInfo.isSendCatalog());
        if (!StringUtils.isEmpty(userInfo.getAddresses().get(0).getStreet1())) {
            Set<Address> addresses = new HashSet<>();
            for (AddressDTO address : userInfo.getAddresses()) {
                Address address1 = new Address();
                address1.setStreet1(address.getStreet1());
                address1.setStreet2(address.getStreet2());
                address1.setCity(address.getCity());
                address1.setState(address.getState());
                address1.setZip(address.getZip());
                addresses.add(address1);
            }
            newUserInfo.setAddresses(addresses);
        }
        userRepository.save(newUserInfo);
        RoleInfo roles = new RoleInfo();
        roles.setRoleId(3L);
        roles.setRoleName("USER");
        //rolesRepository.save(roles);
        Set<RoleInfo> roleInfoSet = new HashSet<>();
        roleInfoSet.add(roles);
        newUserInfo.setRolesInfo(roleInfoSet);
        return newUserInfo;
    }

}
