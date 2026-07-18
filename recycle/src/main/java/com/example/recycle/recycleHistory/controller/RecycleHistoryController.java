package com.example.recycle.recycleHistory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecycleHistoryController {
    @GetMapping("/recycleHistory")
    public String eventLog() {
        return "forward:/pages/recycleHistory.html";
    }
}
