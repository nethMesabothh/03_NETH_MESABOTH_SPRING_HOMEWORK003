package com.both.eventticketingsystem.service;

import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.request.AttendeeRequest;
import com.both.eventticketingsystem.model.response.APIResponseAttendee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAttendeeService {
	ResponseEntity<APIResponseAttendee<List<Attendee>>> getAllAttendee(Integer page, Integer size);

	ResponseEntity<APIResponseAttendee<Attendee>> getAttendeeById(Long attendeeId);

	ResponseEntity<APIResponseAttendee<Attendee>> createAttendee(AttendeeRequest request);

	ResponseEntity<APIResponseAttendee<Attendee>> updateAttendeeById(Long attendeeId, AttendeeRequest request);

	ResponseEntity<APIResponseAttendee<Attendee>> deleteAttendeeById(Long attendeeId);
}
