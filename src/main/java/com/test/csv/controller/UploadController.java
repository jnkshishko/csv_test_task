package com.test.csv.controller;

import com.test.csv.dto.EventDto;
import com.test.csv.utils.CsvUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class UploadController {

    @PostMapping(value = "/upload", consumes = "text/csv")
    public void uploadSimple(@RequestBody InputStream body) throws IOException {
        List<EventDto> dtos = CsvUtils.read(EventDto.class, body);
        dtos.size();
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
        List<EventDto> dtos = CsvUtils.read(EventDto.class, file.getInputStream());
        dtos.size();
    }

}
