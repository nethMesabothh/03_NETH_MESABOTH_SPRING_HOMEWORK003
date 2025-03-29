package com.both.eventticketingsystem.controller;

import com.both.eventticketingsystem.model.entity.Event;
import com.both.eventticketingsystem.model.request.EventRequest;
import com.both.eventticketingsystem.model.response.APIResponseEvent;
import com.both.eventticketingsystem.service.implementation.EventService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

	private final EventService eventService;

	public EventController(EventService eventService) {
		this.eventService = eventService;
	}

	@GetMapping
	public ResponseEntity<APIResponseEvent<List<Event>>> getAllEvents(@RequestParam(defaultValue = "1") @Positive Integer page, @RequestParam(defaultValue = "10") @Positive Integer size) {
		return eventService.getAllEvents(page, size);
	}

	@GetMapping("/{event_id}")
	public ResponseEntity<APIResponseEvent<Event>> getEventById(@PathVariable("event_id") Long eventId) {
		return eventService.getEventById(eventId);
	}

	@PostMapping
	public ResponseEntity<APIResponseEvent<Event>> createEvent(@RequestBody @Valid EventRequest request) {
		return eventService.createEvent(request);
	}

	@PutMapping("/{event_id}")
	public ResponseEntity<APIResponseEvent<Event>> updateEventById(@PathVariable("event_id") Long eventId, @RequestBody @Valid EventRequest request) {
		return eventService.updateEventById(eventId, request);
	}

	@DeleteMapping("/{event_id}")
	public ResponseEntity<APIResponseEvent<Event>> deleteEventById(@PathVariable("event_id") Long eventId) {
		return eventService.deleteEventById(eventId);
	}


}

// Still have event-attendee many to many
// Endpoint for event-attendee
