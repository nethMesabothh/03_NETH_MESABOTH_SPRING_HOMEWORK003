package com.both.eventticketingsystem.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {

	@NotNull
	@NotBlank
	@Size(min = 3, max = 10, message = "Attendee name must be between 3 and 10 characters")
	private String attendeeName;

	@NotNull
	@NotBlank
	@Email
	private String email;

	private List<Long> eventIds;
}
