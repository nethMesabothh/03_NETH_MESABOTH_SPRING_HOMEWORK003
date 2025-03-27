package com.both.eventticketingsystem.controller;

import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.entity.Venue;
import com.both.eventticketingsystem.model.request.VenueRequest;
import com.both.eventticketingsystem.model.response.APIResponseVenue;
import com.both.eventticketingsystem.service.implementation.VenueService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {

	private final VenueService venueService;

	public VenueController(VenueService venueService) {
		this.venueService = venueService;
	}

	@GetMapping
	public ResponseEntity<APIResponseVenue<List<Venue>>> getAllVenues(@RequestParam(defaultValue = "1") @Positive Integer page, @RequestParam(defaultValue = "10") @Positive Integer size) {
		return venueService.getAllVenues(page, size);
	}

	@GetMapping("/{venue_id}")
	public ResponseEntity<APIResponseVenue<Venue>> getVenueById(@PathVariable("venue_id") Long venueId) {
		return venueService.getVenueById(venueId);
	}

	@PostMapping
	public ResponseEntity<APIResponseVenue<Venue>> createVenue(@RequestBody @Valid VenueRequest request) {
		return venueService.createVenue(request);
	}

	@PutMapping("/{venue_id}")
	public ResponseEntity<APIResponseVenue<Venue>> updateVenueById(@PathVariable("venue_id") Long venueId, @RequestBody @Valid VenueRequest request) {

		return venueService.updateVenueById(venueId, request);

	}

	@DeleteMapping("/{venue_id}")
	public ResponseEntity<APIResponseVenue<Venue>> deleteVenueById(@PathVariable("venue_id") Long venueId) {
		return venueService.deleteVenueById(venueId);

	}
}
