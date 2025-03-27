package com.both.eventticketingsystem.service;

import com.both.eventticketingsystem.model.entity.Event;
import com.both.eventticketingsystem.model.response.APIResponseEvent;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEventService {
	ResponseEntity<APIResponseEvent<List<Event>>> getAllEvents(Integer page, Integer size);
}
