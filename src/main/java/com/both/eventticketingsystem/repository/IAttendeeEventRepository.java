package com.both.eventticketingsystem.repository;

import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAttendeeEventRepository {
	@Results(id = "attendeeEventMapper", value = {
					@Result(property = "attendeeId", column = "attendee_id"),
					@Result(property = "attendeeName", column = "attendee_name"),
	})
	@Select("""
					SELECT a.* FROM event_attendee ea INNER JOIN attendees a ON ea.attendee_id = a.attendee_id WHERE ea.event_id = #{eventId}
					""")
	List<Attendee> getAllAttendeesByEventId(Long eventId);

	@Insert("""
					INSERT INTO event_attendee VALUES (#{eventId}, #{attendeeId})
					""")
	void insertAttendeesById(Long eventId, Long attendeeId);

	@Delete("""
					DELETE FROM event_attendee WHERE event_id = #{eventId}
					""")
	void deleteEventAttendeeByEventId(Long eventId);

}
