package com.both.eventticketingsystem.service.implementation;

import com.both.eventticketingsystem.model.entity.Event;
import com.both.eventticketingsystem.model.response.APIResponseEvent;
import com.both.eventticketingsystem.repository.IEventRepository;
import com.both.eventticketingsystem.service.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService implements IEventService {

	private final IEventRepository eventRepository;

	public EventService(IEventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public ResponseEntity<APIResponseEvent<List<Event>>> getAllEvents(Integer page, Integer size) {

		int offset = (page - 1) * size;

		List<Event> events = eventRepository.getAllEvents(offset, size);

		APIResponseEvent<List<Event>> response = new APIResponseEvent<>("All events have been successfully fetched.", events, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}
}
