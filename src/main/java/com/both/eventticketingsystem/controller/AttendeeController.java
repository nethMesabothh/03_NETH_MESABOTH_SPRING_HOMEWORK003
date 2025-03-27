package com.both.eventticketingsystem.controller;

import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.request.AttendeeRequest;
import com.both.eventticketingsystem.service.implementation.AttendeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {

	private final AttendeeService attendeeService;

	public AttendeeController(AttendeeService attendeeService) {
		this.attendeeService = attendeeService;
	}

	@GetMapping
	public List<Attendee> getAllAttendee(@RequestParam(defaultValue = "1") @Positive Integer page, @RequestParam(defaultValue = "10") @Positive Integer size) {
		return attendeeService.getAllAttendee(page, size);
	}

	@GetMapping("/{attendee_id}")
	public ResponseEntity<Attendee> getAttendeeById(@PathVariable("attendee_id") Long attendeeId) {
		Attendee attendee = attendeeService.getAttendeeById(attendeeId);
		return ResponseEntity.ok(attendee);
	}

	@PostMapping
	public ResponseEntity<Attendee> createAttendee(@RequestBody @Valid AttendeeRequest request) {
		Attendee attendee = attendeeService.createAttendee(request);
		return ResponseEntity.ok(attendee);
	}


}
