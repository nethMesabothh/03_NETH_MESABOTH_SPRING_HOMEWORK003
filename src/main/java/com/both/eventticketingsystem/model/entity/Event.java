package com.both.eventticketingsystem.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	private Long eventId;
	private String eventName;
	private LocalDateTime eventDate;
	private Venue venue;
}
