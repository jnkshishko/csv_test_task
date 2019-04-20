package com.test.csv.dao.impl;

import com.test.csv.entity.Event;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepositoryImpl {

    private NamedParameterJdbcTemplate template;

    public EventRepositoryImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void insert(Event event) {
        final String sql = "INSERT INTO CSV (SSOID, TS, GRP, TYPE_, SUB_TYPE, URL, ORG_ID, FORM_ID, CODE, LTPA, SUDIRRESPONSE, YMDH) " +
                "VALUES (:ssoid, :ts, :grp, :type_, :sub_type, :url, :org_id, :form_id, :code, :lpta, :sudirresponse, :ymdh)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("ssoid", event.getSsoid())
                .addValue("ts", event.getTs())
                .addValue("grp", event.getGrp())
                .addValue("type_", event.getType())
                .addValue("sub_type", event.getSubtype())
                .addValue("url", event.getUrl())
                .addValue("org_id", event.getOrgId())
                .addValue("form_id", event.getFormId())
                .addValue("code", event.getCode())
                .addValue("lpta", event.getLtpa())
                .addValue("sudirresponse", event.getSudirresponse())
                .addValue("ymdh", event.getYmdh());
        template.update(sql, param, holder);
    }

    public List<Event> getEventsForLastHour(Long from, Long to) {
        final String sql = "SELECT * FROM csv c " +
                "WHERE c.ts IN (:from, :to)";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("from", from)
                .addValue("to", to);
        return template.queryForList(sql, param, Event.class);
    }

    public void insert2(Event event) {
//        eventRepository.insert(event);
    }

}
