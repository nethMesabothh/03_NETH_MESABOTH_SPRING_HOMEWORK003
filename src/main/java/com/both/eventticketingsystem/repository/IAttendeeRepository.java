package com.both.eventticketingsystem.repository;

import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.request.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAttendeeRepository {


	@Results(id = "attendeeMapper", value = {
					@Result(property = "attendeeId", column = "attendee_id"),
					@Result(property = "attendeeName", column = "attendee_name")
	})
	@Select("""
					SELECT * FROM attendees
					OFFSET #{offset} LIMIT #{size}
					""")
	List<Attendee> getAllAttendee(int offset, Integer size);

	@ResultMap("attendeeMapper")
	@Select("""
					SELECT * FROM attendees WHERE attendee_id = #{attendeeId}
					""")
	Attendee getAttendeeById(Long attendeeId);

	@ResultMap("attendeeMapper")
	@Select("""
					INSERT INTO attendees VALUES (default, #{req.attendeeName}, #{req.email} ) RETURNING *;
					""")
	Attendee createAttendee(@Param("req") AttendeeRequest request);

	@ResultMap("attendeeMapper")
	@Select("""
					UPDATE attendees SET attendee_name = #{req.attendeeName}, email = #{req.email} WHERE attendee_id = #{attendeeId} RETURNING *;
					""")
	Attendee updateAttendeeById(Long attendeeId, @Param("req") AttendeeRequest request);

	@ResultMap("attendeeMapper")
	@Select("""
					DELETE FROM attendees WHERE attendee_id = #{attendeeId} RETURNING *;
					""")
	Attendee deleteAttendeeById(Long attendeeId);
}
