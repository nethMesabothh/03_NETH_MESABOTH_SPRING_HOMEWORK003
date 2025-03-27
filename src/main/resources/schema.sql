-- Create Attendees Table
CREATE TABLE attendees
(
    attendee_id   SERIAL PRIMARY KEY,
    attendee_name VARCHAR(255)        NOT NULL,
    email         VARCHAR(255) UNIQUE NOT NULL
);

-- Create Venues Table
CREATE TABLE venues
(
    venue_id   SERIAL PRIMARY KEY,
    venue_name VARCHAR(255) NOT NULL,
    location   VARCHAR(255) NOT NULL
);

-- Create Events Table
CREATE TABLE events
(
    event_id   SERIAL PRIMARY KEY,
    event_name VARCHAR(255) NOT NULL,
    event_date TIMESTAMP    NOT NULL,
    venue_id   INT          NOT NULL,
    CONSTRAINT fk_venue FOREIGN KEY (venue_id) REFERENCES venues (venue_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE event_attendee
(
    event_id    INT NOT NULL,
    attendee_id INT NOT NULL,
    PRIMARY KEY (event_id, attendee_id),
    CONSTRAINT fk_event FOREIGN KEY (event_id) REFERENCES events (event_id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_attendee FOREIGN KEY (attendee_id) REFERENCES attendees (attendee_id) ON DELETE CASCADE ON UPDATE CASCADE
);
