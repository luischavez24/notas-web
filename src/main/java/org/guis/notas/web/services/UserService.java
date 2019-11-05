package org.guis.notas.web.services;

import java.util.*;
import java.util.stream.Collectors;

import feign.FeignException;
import org.guis.notas.web.config.UserWithInfo;
import org.guis.notas.web.entities.Parent;
import org.guis.notas.web.entities.Person;
import org.guis.notas.web.entities.Role;
import org.guis.notas.web.entities.UserCredentials;
import org.guis.notas.web.models.UserInfo;
import org.guis.notas.web.repositories.ParentsRepository;
import org.guis.notas.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements UserDetailsService, UserInfoService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParentsRepository parentsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User doesn't exists"));
        UserInfo info = findUserInfoByUserCredentials(user);
        return buildUser(user, info, buildAuthorities(user.getRoles()));
    }

    private UserWithInfo buildUser (UserCredentials user, UserInfo info, List<GrantedAuthority> authorities) {
        return new UserWithInfo(user, info, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .filter(r -> r.isActive())
                .map(r -> new SimpleGrantedAuthority(r.getRoleId()))
                .collect(Collectors.toList());
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        Optional<UserCredentials> user = userRepository.findByUsername(username);

        return findUserInfoByUserCredentials(user.orElseThrow(() -> new RuntimeException("User doesn't exists")));
    }

    private UserInfo findUserInfoByUserCredentials(UserCredentials user) {

        Person personForUser = user.getPerson();

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(user.getUsername());
        userInfo.setPhotoUrl(user.getPhotoUrl());
        if(personForUser.getNames() != null && personForUser.getPaternalSurname() != null) {
            userInfo.setNames(personForUser.getNames());
            userInfo.setPaternalSurname(personForUser.getPaternalSurname());
            userInfo.setMaternalSurname(personForUser.getMaternalSurname());

        } else {
            String idDocument = personForUser.getIdDocument();

            try {
                Parent parent = parentsRepository.findByDni(idDocument);
                userInfo.setNames(parent.getNames());
                userInfo.setPaternalSurname(parent.getPaternalSurname());
                userInfo.setMaternalSurname(parent.getMaternalSurname());
            } catch (FeignException.NotFound e) {
                throw new RuntimeException("User doesn't exists");
            }
        }

        return userInfo;
    }
}