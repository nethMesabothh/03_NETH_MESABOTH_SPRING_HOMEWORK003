package com.both.eventticketingsystem.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {

	@NotNull
	@NotBlank
	@Size(min = 3, max = 10, message = "venue name must be between 3 and 10 characters")
	private String venueName;

	@NotNull
	@NotBlank
	@Size(min = 5, message = "location must be at least 5 characters")
	private String location;
}
