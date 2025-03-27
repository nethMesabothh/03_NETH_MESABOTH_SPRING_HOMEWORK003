package com.both.eventticketingsystem.service;

import com.both.eventticketingsystem.model.entity.Venue;
import com.both.eventticketingsystem.model.request.VenueRequest;
import com.both.eventticketingsystem.model.response.APIResponseVenue;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVenueService {

	ResponseEntity<APIResponseVenue<List<Venue>>> getAllVenues(Integer page, Integer size);

	ResponseEntity<APIResponseVenue<Venue>> getVenueById(Long venueId);

	ResponseEntity<APIResponseVenue<Venue>> createVenue(VenueRequest request);

	ResponseEntity<APIResponseVenue<Venue>> updateVenueById(Long venueId ,VenueRequest request);

	ResponseEntity<APIResponseVenue<Venue>> deleteVenueById(Long venueId);
}
