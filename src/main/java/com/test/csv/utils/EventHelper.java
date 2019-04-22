package com.test.csv.utils;

import com.test.csv.dto.EventDto;
import com.test.csv.entity.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventHelper {

    public static EventDto copyEventToDto (Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setSsoid(event.getSsoid());
        eventDto.setTs(event.getTs());
        eventDto.setGrp(event.getGrp());
        eventDto.setType(event.getType());
        eventDto.setSubtype(event.getSubtype());
        eventDto.setUrl(event.getUrl());
        eventDto.setOrgid(event.getOrgId());
        eventDto.setFormid(event.getFormId());
        eventDto.setCode(event.getCode());
        eventDto.setLtpa(event.getLtpa());
        eventDto.setSudirresponse(event.getSudirresponse());
        eventDto.setYmdh(event.getYmdh().toString());
        return eventDto;
    }

    public static Event copyDtoToEvent(EventDto dto) throws ParseException {
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
        return event;
    }

    public static Date unixTimeToDate(Long unixTime) {
        Date date = new Date ();
        date.setTime(unixTime*1000);
        return date;
    }

    public static long dateToUnixTime(Date date) {
        return date.getTime();
    }

}
