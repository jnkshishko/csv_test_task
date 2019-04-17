package com.test.csv.controller;

import com.test.csv.dto.EventDto;
import com.test.csv.service.EventService;
import com.test.csv.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

@RestController
public class UploadController {

    @Autowired
    private EventService eventService;

//    public UploadController(EventService eventService) {
//        this.eventService = eventService;
//    }

    @PostMapping(value = "/upload", consumes = "text/csv")
    public void uploadSimple(@RequestBody InputStream body) throws IOException, ParseException {
        eventService.saveAllEvents(CsvUtils.read(EventDto.class, body));
//        dtos.size();
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        eventService.saveAllEvents(CsvUtils.read(EventDto.class, file.getInputStream()));
//        dtos.size();
    }

}
