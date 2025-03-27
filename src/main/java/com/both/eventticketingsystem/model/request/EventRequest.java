package com.both.eventticketingsystem.model.request;

import com.both.eventticketingsystem.model.entity.Venue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
	private String eventName;
	private LocalDateTime eventDate;
	private Long venueId;
}
