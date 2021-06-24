package com.vmo.backendservices.service;

import com.vmo.backendservices.persistance.Domain.RoleInfo;
import com.vmo.backendservices.persistance.Domain.UserInfo;
import com.vmo.backendservices.persistance.Repository.UserRepository;
import com.vmo.backendservices.persistance.Repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService, UserDetailService {

    @Autowired
    UserRolesRepository rolesRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userRepository.findByUsername(username);
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


}
