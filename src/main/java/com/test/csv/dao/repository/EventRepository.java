package com.test.csv.dao.repository;


import com.test.csv.entity.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, String> {

    @Query(
            value = "SELECT * FROM csv c where c.ts in (?1, ?2)",
    nativeQuery = true)
    List<Event> getEventsForLastHour(Long from, Long to);

    @Query(
            value = "SELECT t.form_id FROM (SELECT count(form_id) as c, form_id FROM csv WHERE form_id NOT LIKE '' " +
                    "GROUP BY form_id ORDER BY c DESC LIMIT 5) t",
    nativeQuery = true)
    List<String> topFive();

    @Query(
            value = "SELECT * FROM csv c",
            nativeQuery = true)
    List<Event> getAll();
}
