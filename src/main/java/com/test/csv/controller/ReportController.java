package com.test.csv.controller;

import com.test.csv.dto.TopFormDto;
import com.test.csv.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private EventService eventService;

    @RequestMapping("/reportC")
    public String getTop(Model model) {
        List<TopFormDto> topList = eventService.getTopForm();
        model.addAttribute("topList", topList);
        return "top";
    }

}
