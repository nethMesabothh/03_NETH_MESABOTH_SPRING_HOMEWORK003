package com.both.eventticketingsystem.service.implementation;

import com.both.eventticketingsystem.exeception.NotFoundException;
import com.both.eventticketingsystem.model.entity.Attendee;
import com.both.eventticketingsystem.model.entity.Venue;
import com.both.eventticketingsystem.model.request.AttendeeRequest;
import com.both.eventticketingsystem.model.request.VenueRequest;
import com.both.eventticketingsystem.model.response.APIResponseVenue;
import com.both.eventticketingsystem.repository.IVenueRepository;
import com.both.eventticketingsystem.service.IVenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VenueService implements IVenueService {

	private final IVenueRepository venueRepository;


	public VenueService(IVenueRepository venueRepository) {
		this.venueRepository = venueRepository;
	}

	@Override
	public ResponseEntity<APIResponseVenue<List<Venue>>> getAllVenues(Integer page, Integer size) {

		int offset = (page - 1) * size;
		List<Venue> venues = venueRepository.getAllVenues(offset, size);


		APIResponseVenue<List<Venue>> response = new APIResponseVenue<>("All venues have been successfully fetched.", venues, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseVenue<Venue>> getVenueById(Long venueId) {
		Venue venue = venueRepository.getVenueById(venueId);
		if (venue == null) {
			throw new NotFoundException("venue with Id : " + venueId + " not found");
		}

		APIResponseVenue<Venue> response = new APIResponseVenue<>("Venue with id : " + venueId + " have been successfully fetched.", venue, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseVenue<Venue>> createVenue(VenueRequest request) {
		Venue venue = venueRepository.createVenue(request);

		APIResponseVenue<Venue> response = new APIResponseVenue<>("Venue have been successfully created.", venue, HttpStatus.CREATED, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseVenue<Venue>> updateVenueById(Long venueId, VenueRequest request) {
		Venue venue = venueRepository.updateVenueById(venueId, request);
		if (venue == null) {
			throw new NotFoundException("venue with Id : " + venueId + " not found");
		}

		APIResponseVenue<Venue> response = new APIResponseVenue<>("Venue with id : " + venueId + " have been successfully updated.", venue, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<APIResponseVenue<Venue>> deleteVenueById(Long venueId) {
		Venue venue = venueRepository.deleteVenueById(venueId);
		if (venue == null) {
			throw new NotFoundException("venue with Id : " + venueId + " not found");
		}

		APIResponseVenue<Venue> response = new APIResponseVenue<>("Venue with id : " + venueId + " have been successfully deleted.", venue, HttpStatus.OK, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

}
