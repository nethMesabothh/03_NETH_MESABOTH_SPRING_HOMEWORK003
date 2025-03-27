package com.both.eventticketingsystem.controller;

import com.both.eventticketingsystem.model.entity.Event;
import com.both.eventticketingsystem.model.response.APIResponseEvent;
import com.both.eventticketingsystem.service.implementation.EventService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

// Still have event-attendee many to many
// Endpoint for event-attendee
// and four more method for Event
