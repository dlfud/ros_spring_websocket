package com.example.recycle.general.controller;

import java.util.Map;

import ch.qos.logback.core.model.Model;
import com.example.recycle.general.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.recycle.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GeneralController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private GeneralService generalService;

	// 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "forward:/index.html";
    }

    // 메인 페이지
    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }

    // 로그인 성공 후 이동할 페이지
    @GetMapping("/dashboard")
    public String dashboard() {
        return "forward:/pages/dashboard.html";
    }

    @PostMapping("/join")
    @ResponseBody
    public ResponseEntity<Void> join(@RequestBody MemberDto memberDto) throws Exception{
        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));

        generalService.join(memberDto);
        return ResponseEntity.ok().build();
    }
}