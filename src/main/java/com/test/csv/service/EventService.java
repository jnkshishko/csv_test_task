package com.test.csv.service;

import com.test.csv.dao.repository.EventRepository;
import com.test.csv.dto.EventDto;
import com.test.csv.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EventService {

    private static final Logger LOG = LoggerFactory.getLogger(EventService.class);

    @Autowired
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void saveAllEvents(List<EventDto> dtos) throws ParseException {
        LOG.debug("#EventService() saveAllEvents(): START");
        if (dtos == null || dtos.isEmpty()){
            return;
        }
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
            Date date = new SimpleDateFormat("yyyy-MM-dd-HH").parse(dto.getYmdh());
            event.setYmdh(date);
            eventRepository.save(event);
        }
        LOG.debug("#EventService() saveAllEvents(): COMPLETE");
    }

//    public List<Event> getUsersForLastHour() {
//        Long to = dateToUnixTime(new Date());
//        Long from = dateToUnixTime(new Date(System.currentTimeMillis() - 360000 * 1000));
//        return eventRepositoryImpl.getEventsForLastHour(from, to);
//    }
    public List<String> getTopForm() {
        return eventRepository.topFive();
    }
}
