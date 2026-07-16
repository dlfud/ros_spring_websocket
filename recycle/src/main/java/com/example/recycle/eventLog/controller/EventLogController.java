package com.example.recycle.eventLog.controller;

import com.example.recycle.eventLog.service.EventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventLogController {
    @Autowired
    private EventLogService eventLogService;

    // 로그인 성공 후 이동할 페이지
    @GetMapping("/eventLog")
    public String eventLog() {
        return "forward:/pages/eventLog.html";
    }

}