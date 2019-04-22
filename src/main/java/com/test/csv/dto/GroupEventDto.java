package com.test.csv.dto;

import com.test.csv.entity.Event;

import java.util.List;

public class GroupEventDto {

    private String ssoid;
    private List<Event> events;

    public GroupEventDto() {
    }

    public GroupEventDto(String ssoid, List<Event> events) {
        this.ssoid = ssoid;
        this.events = events;
    }

    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
