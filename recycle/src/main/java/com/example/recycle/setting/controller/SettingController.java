package com.example.recycle.setting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SettingController {
    @GetMapping("/setting")
    public String dashboard() {
        return "forward:/pages/setting.html";
    }
}
