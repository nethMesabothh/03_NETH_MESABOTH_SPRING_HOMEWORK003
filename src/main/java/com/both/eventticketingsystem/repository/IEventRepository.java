package com.both.eventticketingsystem.repository;

import com.both.eventticketingsystem.model.entity.Event;
import com.both.eventticketingsystem.model.request.EventRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IEventRepository {
	@Results(id = "eventMapper", value = {
					@Result(property = "eventId", column = "event_id"),
					@Result(property = "eventName", column = "event_name"),
					@Result(property = "eventDate", column = "event_date"),
					@Result(property = "venue", column = "venue_id", one = @One(select = "com.both.eventticketingsystem.repository.IVenueRepository.getVenueById")),
					@Result(property = "attendees", column = "event_id", many = @Many(select = "com.both.eventticketingsystem.repository.IAttendeeEventRepository.getAllAttendeesByEventId"))
	})
	@Select("""
					SELECT * FROM events OFFSET #{offset} LIMIT #{size}
					""")
	List<Event> getAllEvents(int offset, Integer size);

	@ResultMap("eventMapper")
	@Select("""
					SELECT * FROM events WHERE event_id = #{eventId}
					""")
	Event getEventById(Long eventId);

	@ResultMap("eventMapper")
	@Select("""
					INSERT INTO events VALUES (default, #{req.eventName}, #{req.eventDate}, #{req.venueId}) RETURNING *
					""")
	Event createEvent(@Param("req") EventRequest request);

	@ResultMap("eventMapper")
	@Select("""
					UPDATE events SET event_name = #{req.eventName}, event_date = #{req.eventDate}, venue_id = #{req.venueId} WHERE event_id = #{eventId} RETURNING *
					""")
	Event updateEventById(Long eventId, @Param("req") EventRequest request);

	@ResultMap("eventMapper")
	@Select("""
					DELETE FROM events WHERE event_id = #{eventId} RETURNING *
					""")
	Event deleteEventById(Long eventId);
}
