package com.both.eventticketingsystem.service;

import com.both.eventticketingsystem.model.entity.Event;
import com.both.eventticketingsystem.model.request.EventRequest;
import com.both.eventticketingsystem.model.response.APIResponseEvent;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEventService {
	ResponseEntity<APIResponseEvent<List<Event>>> getAllEvents(Integer page, Integer size);

	ResponseEntity<APIResponseEvent<Event>> getEventById(Long eventId);

	ResponseEntity<APIResponseEvent<Event>> createEvent(EventRequest request);

	ResponseEntity<APIResponseEvent<Event>> updateEventById(Long eventId, EventRequest request);

	ResponseEntity<APIResponseEvent<Event>> deleteEventById(Long eventId);
}
