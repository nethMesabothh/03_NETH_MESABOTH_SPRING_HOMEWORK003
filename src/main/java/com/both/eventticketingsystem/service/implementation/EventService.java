package com.both.eventticketingsystem.service.implementation;

import com.both.eventticketingsystem.exeception.NotFoundException;
import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.entity.Event;
import com.both.eventticketingsystem.model.request.EventRequest;
import com.both.eventticketingsystem.model.response.APIResponseEvent;
import com.both.eventticketingsystem.repository.IAttendeeEventRepository;
import com.both.eventticketingsystem.repository.IAttendeeRepository;
import com.both.eventticketingsystem.repository.IEventRepository;
import com.both.eventticketingsystem.repository.IVenueRepository;
import com.both.eventticketingsystem.service.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService implements IEventService {

	private final IEventRepository eventRepository;
	private final IVenueRepository venueRepository;
	private final IAttendeeEventRepository attendeeEventRepository;
	private final IAttendeeRepository attendeeRepository;


	public EventService(IEventRepository eventRepository, IVenueRepository venueRepository, IAttendeeEventRepository attendeeEventRepository, IAttendeeRepository attendeeRepository) {
		this.eventRepository = eventRepository;
		this.venueRepository = venueRepository;
		this.attendeeEventRepository = attendeeEventRepository;
		this.attendeeRepository = attendeeRepository;
	}

	@Override
	public ResponseEntity<APIResponseEvent<List<Event>>> getAllEvents(Integer page, Integer size) {

		int offset = (page - 1) * size;

		List<Event> events = eventRepository.getAllEvents(offset, size);

		APIResponseEvent<List<Event>> response = new APIResponseEvent<>("All events have been successfully fetched.", events, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseEvent<Event>> getEventById(Long eventId) {

		Event event = eventRepository.getEventById(eventId);

		if (event == null) {
			throw new NotFoundException("Event with id : " + eventId + " not found");
		}

		APIResponseEvent<Event> response = new APIResponseEvent<>("Event with id : " + eventId + " have been successfully fetched", event, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseEvent<Event>> createEvent(EventRequest request) {

		// Not working?
		if (request.getVenueId() == null) {
			throw new NotFoundException("Venue id is required");
		}

		if (venueRepository.existsById(request.getVenueId()) <= 0) {
			throw new NotFoundException("Venue ID " + request.getVenueId() + " does not exist");
		}

		Event event = eventRepository.createEvent(request);

		for (Long attendeeId : request.getAttendeesId()) {
			Attendee attendee = attendeeRepository.getAttendeeById(attendeeId);

			if (attendee == null) {
				throw new NotFoundException("Attendee id " + attendeeId + " does not exist");
			}

			attendeeEventRepository.insertAttendeesById(event.getEventId(), attendeeId);
		}

		if (event == null) {
			throw new NotFoundException("event id not found!");
		}

		Event getEventById = eventRepository.getEventById(event.getEventId());

		APIResponseEvent<Event> response = new APIResponseEvent<>("Event have been successfully created", getEventById, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseEvent<Event>> updateEventById(Long eventId, EventRequest request) {

		if (venueRepository.existsById(request.getVenueId()) <= 0) {
			throw new NotFoundException("Venue ID " + request.getVenueId() + " does not exist");
		}
		Event event = eventRepository.updateEventById(eventId, request);

		if (event == null) {
			throw new NotFoundException("Event with id : " + eventId + " not found");
		}

		attendeeEventRepository.deleteEventAttendeeByEventId(eventId);

		for (Long attendeeId : request.getAttendeesId()) {
			Attendee attendee = attendeeRepository.getAttendeeById(attendeeId);

			if (attendee == null) {
				throw new NotFoundException("Attendee id " + attendeeId + " does not exist");
			}
			attendeeEventRepository.insertAttendeesById(eventId, attendeeId);
		}


		Event getEventById = eventRepository.getEventById(event.getEventId());

		APIResponseEvent<Event> response = new APIResponseEvent<>("Event have been successfully updated", getEventById, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseEvent<Event>> deleteEventById(Long eventId) {

		Event event = eventRepository.deleteEventById(eventId);

		if (event == null) {
			throw new NotFoundException("Event with id : " + eventId + " not found");
		}

		APIResponseEvent<Event> response = new APIResponseEvent<>("Event with id : " + eventId + " have been successfully deleted", event, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);

	}
}
