package com.example.recycle.general.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.recycle.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GeneralController {
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
        return "forward:/dashboard.html";
    }
}