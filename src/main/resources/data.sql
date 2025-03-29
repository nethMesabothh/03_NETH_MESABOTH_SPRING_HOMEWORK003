-- Insert into Attendees
INSERT INTO attendees (attendee_name, email)
VALUES ('Alice Johnson', 'alice@example.com'),
       ('Bob Smith', 'bob@example.com'),
       ('Charlie Davis', 'charlie@example.com'),
       ('Diana Evans', 'diana@example.com'),
       ('Edward Green', 'edward@example.com'),
       ('Fiona Harris', 'fiona@example.com'),
       ('George King', 'george@example.com'),
       ('Helen Lopez', 'helen@example.com'),
       ('Ian Mitchell', 'ian@example.com'),
       ('Jessica Nelson', 'jessica@example.com');


-- Insert into Venues
INSERT INTO venues (venue_name, location)
VALUES ('Grand Hall', 'New York'),
       ('Conference Center', 'San Francisco'),
       ('Tech Park', 'Los Angeles'),
       ('City Expo Center', 'Chicago');

-- Insert into Events
INSERT INTO events (event_name, event_date, venue_id)
VALUES ('Tech Conference 2025', '2025-05-10', 1),
       ('Startup Meetup', '2025-06-15', 2),
       ('AI Workshop', '2025-07-20', 3),
       ('Cybersecurity Summit', '2025-08-25', 1),
       ('Blockchain Forum', '2025-09-30', 4);


-- Insert into Event_Attendee (Random attendees for events)
INSERT INTO event_attendee (event_id, attendee_id)
VALUES (1, 6),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 6),
       (3, 7),
       (3, 8),
       (4, 9),
       (4, 10),
       (5, 7);

-- Update Date Events
ALTER TABLE events
    ALTER COLUMN event_date TYPE TIMESTAMP
