package com.both.eventticketingsystem.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendee {
	private Long attendeeId;
	private String attendeeName;
	private String email;
}
