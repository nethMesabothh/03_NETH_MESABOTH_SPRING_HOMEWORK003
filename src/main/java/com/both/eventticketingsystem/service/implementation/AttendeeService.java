package com.both.eventticketingsystem.service.implementation;

import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.entity.Venue;
import com.both.eventticketingsystem.model.request.AttendeeRequest;
import com.both.eventticketingsystem.model.response.APIResponseAttendee;
import com.both.eventticketingsystem.model.response.APIResponseVenue;
import com.both.eventticketingsystem.repository.IAttendeeRepository;
import com.both.eventticketingsystem.service.IAttendeeService;
import com.both.eventticketingsystem.exeception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendeeService implements IAttendeeService {

	private final IAttendeeRepository attendeeRepository;

	public AttendeeService(IAttendeeRepository attendeeRepository) {
		this.attendeeRepository = attendeeRepository;
	}

	@Override
	public ResponseEntity<APIResponseAttendee<List<Attendee>>> getAllAttendee(Integer page, Integer size) {
		int offset = (page - 1) * size;
		List<Attendee> attendees = attendeeRepository.getAllAttendee(offset, size);


		APIResponseAttendee<List<Attendee>> response = new APIResponseAttendee<>("All attendees have been successfully fetched.", attendees, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseAttendee<Attendee>> getAttendeeById(Long attendeeId) {
		Attendee attendee = attendeeRepository.getAttendeeById(attendeeId);
		if (attendee == null) {
			throw new NotFoundException("Attendee with Id : " + attendeeId + " not found");
		}

		APIResponseAttendee<Attendee> response = new APIResponseAttendee<>("Attendee with id : " + attendeeId + " have been successfully fetched.", attendee, HttpStatus.OK, LocalDateTime.now());


		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseAttendee<Attendee>> createAttendee(AttendeeRequest request) {

		Attendee attendee = attendeeRepository.createAttendee(request);


		APIResponseAttendee<Attendee> response = new APIResponseAttendee<>("Attendee have been successfully created.", attendee, HttpStatus.CREATED, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseAttendee<Attendee>> updateAttendeeById(Long attendeeId, AttendeeRequest request) {

		Attendee attendee = attendeeRepository.updateAttendeeById(attendeeId, request);
		if (attendee == null) {
			throw new NotFoundException("Attendee with Id : " + attendeeId + " not found");
		}

		APIResponseAttendee<Attendee> response = new APIResponseAttendee<>("Attendee with id : " + attendeeId + " have been successfully updated.", attendee, HttpStatus.OK, LocalDateTime.now());


		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseAttendee<Attendee>> deleteAttendeeById(Long attendeeId) {

		Attendee attendee = attendeeRepository.deleteAttendeeById(attendeeId);
		if (attendee == null) {
			throw new NotFoundException("Attendee with Id : " + attendeeId + " not found");
		}


		APIResponseAttendee<Attendee> response = new APIResponseAttendee<>("Attendee with id : " + attendeeId + " have been successfully deleted.", attendee, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}


}
