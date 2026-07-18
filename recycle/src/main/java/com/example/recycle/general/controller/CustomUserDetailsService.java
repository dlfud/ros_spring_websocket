package com.example.recycle.general.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.example.recycle.dao.GeneralDao;
import com.example.recycle.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final GeneralDao generalDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MemberDto member = generalDao.findByUserId(username);

        if(member == null){
            throw new UsernameNotFoundException(username);
        }

        return User.builder()
                .username(member.getId())
                .password(member.getPassword())
                .build();
    }
}