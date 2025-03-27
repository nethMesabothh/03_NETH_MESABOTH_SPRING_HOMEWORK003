package com.both.eventticketingsystem.service;

import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.request.AttendeeRequest;

import java.util.List;

public interface IAttendeeService {
	List<Attendee> getAllAttendee(Integer page, Integer size);

	Attendee getAttendeeById(Long attendeeId);

	Attendee createAttendee(AttendeeRequest request);

}
