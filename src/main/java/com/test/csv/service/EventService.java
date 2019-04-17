package com.test.csv.service;

import com.test.csv.dao.impl.EventRepositoryImpl;
import com.test.csv.dto.EventDto;
import com.test.csv.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private final EventRepositoryImpl eventRepositoryImpl;

    public EventService(EventRepositoryImpl eventRepositoryImpl) {
        this.eventRepositoryImpl = eventRepositoryImpl;
    }

    public void saveAllEvents(List<EventDto> dtos) throws ParseException {
        if (dtos == null || dtos.isEmpty()){
            return;
        }
        List<Event> events = new ArrayList<>();
        for (EventDto dto : dtos) {
            Event event = new Event();
            event.setSsoid(dto.getSsoid());
            event.setTs(dto.getTs());
            event.setGrp(dto.getGrp());
            event.setType(dto.getType());
            event.setSubtype(dto.getSubtype());
            event.setUrl(dto.getUrl());
            event.setOrgId(dto.getOrgid());
            event.setFormId(dto.getFormid());
            event.setCode(dto.getCode());
            event.setLtpa(dto.getLtpa());
            event.setSudirresponse(dto.getSudirresponse());
            event.setYmdh(new SimpleDateFormat("yyyy-MM-dd-HH").parse(dto.getYmdh()));
            eventRepositoryImpl.insert(event);
//            events.add(event);
        }
//        eventRepository.saveAll(events);
    }

}
