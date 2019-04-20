package com.test.csv.controller;

import com.test.csv.dto.EventDto;
import com.test.csv.service.EventService;
import com.test.csv.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

@Controller
public class UploadController {

    @Autowired
    private EventService eventService;

    @PostMapping(value = "/upload", consumes = "text/csv")
    public String uploadSimple(@RequestBody InputStream body) throws IOException, ParseException {
        eventService.saveAllEvents(CsvUtils.read(EventDto.class, body));
        return "redirect:/reports.html";
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public String uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        eventService.saveAllEvents(CsvUtils.read(EventDto.class, file.getInputStream()));
        return "redirect:/reports.html";
    }

//    @RequestMapping("/reportA")
//    @ResponseBody
//    public String getReport(HttpServletRequest request, HttpServletResponse response) {
//        List<Event> events = eventService.getUsersForLastHour();
//        for (int i = 0; i < events.size(); i++) {
//            System.out.print(events.get(i).getSsoid());
//        }
//        return events.get(0).getSsoid();
//    }
    @RequestMapping("/reportC")
    public String getTop(Model model) {
        List <String> topList = eventService.getTopForm();
        model.addAttribute("topList", topList);
        return "redirect:/top.html";
    }

}
