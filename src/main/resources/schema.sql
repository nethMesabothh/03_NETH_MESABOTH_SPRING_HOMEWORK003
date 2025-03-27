-- Create Attendees Table
CREATE TABLE attendees
(
    attendee_id   SERIAL PRIMARY KEY,
    attendee_name VARCHAR(255)        NOT NULL,
    email         VARCHAR(255) UNIQUE NOT NULL
);
