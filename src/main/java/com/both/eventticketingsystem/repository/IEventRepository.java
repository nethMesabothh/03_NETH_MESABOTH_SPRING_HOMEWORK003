package com.both.eventticketingsystem.repository;

import com.both.eventticketingsystem.model.entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IEventRepository {
	@Results(id = "eventMapper", value = {
					@Result(property = "eventId", column = "event_id"),
					@Result(property = "eventName", column = "event_name"),
					@Result(property = "eventDate", column = "event_date"),
					@Result(property = "venue", column = "venue_id", one = @One(select = "com.both.eventticketingsystem.repository.IVenueRepository.getVenueById"))
	})
	@Select("""
					SELECT * FROM events OFFSET #{offset} LIMIT #{size}
					""")
	List<Event> getAllEvents(int offset, Integer size);
}
