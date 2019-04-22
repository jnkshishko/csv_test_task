package com.test.csv.service;

import com.test.csv.dao.repository.EventRepository;
import com.test.csv.dto.EventDto;
import com.test.csv.dto.GroupEventDto;
import com.test.csv.dto.TopFormDto;
import com.test.csv.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static com.test.csv.utils.EventHelper.*;

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
            eventRepository.save(copyDtoToEvent(dto));
        }
        LOG.debug("#EventService() saveAllEvents(): COMPLETE");
    }

    public List<EventDto> getUsersForLastHour() {
        Long to = dateToUnixTime(new Date());
        Long from = dateToUnixTime(new Date(System.currentTimeMillis() - 360000 * 1000));

        List<Event> events = eventRepository.getEventsForLastHour(from, to);
        List<EventDto> dtos = new ArrayList<>();
        for (Event event : events) {
            dtos.add(copyEventToDto(event));
        }
        return dtos;
    }

    public List<TopFormDto> getTopForm() {
        List<String> list = eventRepository.topFive();
        List<TopFormDto> topForms = new ArrayList<>();
        for (String s : list) {
            TopFormDto form = new TopFormDto();
            form.setForm_id(s);
            topForms.add(form);
        }
        return topForms;
    }

    public List<EventDto> getUnfinished() {
        List<Event> events = eventRepository.getAll();
        //групировка по SSOID
        Map<String, List<Event>> map = events.stream()
                .collect(Collectors.groupingBy(Event::getSsoid));
        List<GroupEventDto> groupEventDtos = map.entrySet().stream().map(m -> new GroupEventDto(m.getKey(), m.getValue()))
                .collect(Collectors.toList());
        List<EventDto> dtos = new ArrayList<>();
        //сортировка по времени
        for (GroupEventDto groupEventDto : groupEventDtos) {
            List<Event> sortResult;
            sortResult = groupEventDto.getEvents().stream().sorted((Comparator.comparing(Event::getTs)))
                    .collect(Collectors.toList());
            groupEventDto.setEvents(sortResult);
            boolean exists = true;
            for (Event event : sortResult) {
                if ("send".equals(event.getSubtype().trim())) {
                    exists = true;
                } else if ("success".equals(event.getSubtype().trim())) {
                    exists = true;
                } else {
                    exists = false;
                }
            }
            if (!exists) {
                dtos.add(copyEventToDto(sortResult.stream().reduce((first, second) -> second).get()));
            }
        }
        return dtos;
    }
}
