package com.example.recycle.eventLog.controller;

import com.example.recycle.eventLog.service.EventLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventLogController {
    @Autowired
    private EventLogService eventLogService;

    @GetMapping("/eventLog")
    public String eventLog() {
        return "forward:/pages/eventLog.html";
    }

}