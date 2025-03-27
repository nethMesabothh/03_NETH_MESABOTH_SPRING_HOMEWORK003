package com.both.eventticketingsystem.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseAttendee<T> {
	private String message;
	private T payload;
	private HttpStatus httpStatus;
	private LocalDateTime time;
}
