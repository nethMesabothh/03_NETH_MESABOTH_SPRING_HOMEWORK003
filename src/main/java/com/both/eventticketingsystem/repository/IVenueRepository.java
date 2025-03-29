package com.both.eventticketingsystem.repository;

import com.both.eventticketingsystem.model.entity.Venue;
import com.both.eventticketingsystem.model.request.VenueRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IVenueRepository {

	@Results(id = "venueMapper", value = {
					@Result(property = "venueId", column = "venue_id"),
					@Result(property = "venueName", column = "venue_name"),
	})
	@Select("""
					SELECT * FROM venues
					OFFSET #{offset} LIMIT #{size}
					""")
	List<Venue> getAllVenues(int offset, Integer size);

	@ResultMap("venueMapper")
	@Select("""
					SELECT * FROM venues WHERE venue_id = #{venueId}
					""")
	Venue getVenueById(Long venueId);

	@ResultMap("venueMapper")
	@Select("""
					INSERT INTO venues VALUES (default, #{req.venueName}, #{req.location} ) RETURNING *;
					""")
	Venue createVenue(@Param("req") VenueRequest request);

	@ResultMap("venueMapper")
	@Select("""
					UPDATE venues SET venue_name = #{req.venueName}, location = #{req.location} WHERE venue_id = #{venueId} RETURNING *;
					""")
	Venue updateVenueById(Long venueId, @Param("req") VenueRequest request);

	@ResultMap("venueMapper")
	@Select("""
					DELETE FROM venues WHERE venue_id = #{venueId} RETURNING *;
					""")
	Venue deleteVenueById(Long venueId);

	@Select("""
					SELECT COUNT(*) FROM venues WHERE venue_id = #{venueId}
					""")
	int existsById(Long venueId);
}
