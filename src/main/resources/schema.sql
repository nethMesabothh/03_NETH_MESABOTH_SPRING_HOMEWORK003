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
