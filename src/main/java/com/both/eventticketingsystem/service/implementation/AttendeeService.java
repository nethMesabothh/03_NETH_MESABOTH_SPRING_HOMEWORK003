package com.both.eventticketingsystem.service.implementation;

import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.request.AttendeeRequest;
import com.both.eventticketingsystem.repository.IAttendeeRepository;
import com.both.eventticketingsystem.service.IAttendeeService;
import com.both.eventticketingsystem.exeception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService implements IAttendeeService {

	private final IAttendeeRepository attendeeRepository;

	public AttendeeService(IAttendeeRepository attendeeRepository) {
		this.attendeeRepository = attendeeRepository;
	}

	@Override
	public List<Attendee> getAllAttendee(Integer page, Integer size) {
		int offset = (page - 1) * size;
		return attendeeRepository.getAllAttendee(offset, size);
	}

	@Override
	public Attendee getAttendeeById(Long attendeeId) {
		Attendee attendee = attendeeRepository.getAttendeeById(attendeeId);
		if (attendee == null) {
			throw new NotFoundException("Attendee with ID " + attendeeId + " not found");
		}
		return attendee;
	}

	@Override
	public Attendee createAttendee(AttendeeRequest request) {

		return attendeeRepository.createAttendee(request);
	}


}
