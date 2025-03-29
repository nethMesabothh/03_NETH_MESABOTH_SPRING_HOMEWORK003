package com.both.eventticketingsystem.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {

	@NotNull
	@NotBlank
	@Size(min = 3, max = 10, message = "event name must be between 3 and 10 characters")
	private String eventName;

	private LocalDateTime eventDate;

	@NotNull
	private Long venueId;

	private List<Long> attendeesId;
}
