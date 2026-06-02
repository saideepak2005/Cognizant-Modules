import os

folder = r'c:\Users\91996\Desktop\cog\mysql'
os.makedirs(folder, exist_ok=True)

setup_sql = '''-- Setup script for Local Community Event Portal Database
CREATE DATABASE IF NOT EXISTS event_portal;
USE event_portal;

-- Create User 'sai' if required
CREATE USER IF NOT EXISTS 'sai'@'localhost' IDENTIFIED BY 'sai';
GRANT ALL PRIVILEGES ON event_portal.* TO 'sai'@'localhost';

CREATE TABLE IF NOT EXISTS Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    city VARCHAR(100) NOT NULL,
    registration_date DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS Events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    city VARCHAR(100) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    status ENUM ('upcoming','completed','cancelled'),
    organizer_id INT,
    FOREIGN KEY (organizer_id) REFERENCES Users(user_id)
);

CREATE TABLE IF NOT EXISTS Sessions (
    session_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    title VARCHAR(200) NOT NULL,
    speaker_name VARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE IF NOT EXISTS Registrations (
    registration_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    registration_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE IF NOT EXISTS Feedback (
    feedback_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    event_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comments TEXT,
    feedback_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

CREATE TABLE IF NOT EXISTS Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    event_id INT,
    resource_type ENUM ('pdf','image','link'),
    resource_url VARCHAR(255) NOT NULL,
    uploaded_at DATETIME NOT NULL,
    FOREIGN KEY (event_id) REFERENCES Events(event_id)
);

-- Sample Data Insertions
INSERT IGNORE INTO Users (user_id, full_name, email, city, registration_date) VALUES
(1, 'Alice Johnson', 'alice@example.com', 'New York', '2024-12-01'),
(2, 'Bob Smith', 'bob@example.com', 'Los Angeles', '2024-12-05'),
(3, 'Charlie Lee', 'charlie@example.com', 'Chicago', '2024-12-10'),
(4, 'Diana King', 'diana@example.com', 'New York', '2025-01-15'),
(5, 'Ethan Hunt', 'ethan@example.com', 'Los Angeles', '2025-02-01');

INSERT IGNORE INTO Events (event_id, title, description, city, start_date, end_date, status, organizer_id) VALUES
(1, 'Tech Innovators Meetup', 'A meetup for tech enthusiasts.', 'New York', '2025-06-10 10:00:00', '2025-06-10 16:00:00', 'upcoming', 1),
(2, 'AI & ML Conference', 'Conference on AI and ML advancements.', 'Chicago', '2025-05-15 09:00:00', '2025-05-15 17:00:00', 'completed', 3),
(3, 'Frontend Development Bootcamp', 'Hands-on training on frontend tech.', 'Los Angeles', '2025-07-01 10:00:00', '2025-07-03 16:00:00', 'upcoming', 2);

INSERT IGNORE INTO Sessions (session_id, event_id, title, speaker_name, start_time, end_time) VALUES
(1, 1, 'Opening Keynote', 'Dr. Tech', '2025-06-10 10:00:00', '2025-06-10 11:00:00'),
(2, 1, 'Future of Web Dev', 'Alice Johnson', '2025-06-10 11:15:00', '2025-06-10 12:30:00'),
(3, 2, 'AI in Healthcare', 'Charlie Lee', '2025-05-15 09:30:00', '2025-05-15 11:00:00'),
(4, 3, 'Intro to HTML5', 'Bob Smith', '2025-07-01 10:00:00', '2025-07-01 12:00:00');

INSERT IGNORE INTO Registrations (registration_id, user_id, event_id, registration_date) VALUES
(1, 1, 1, '2025-05-01'),
(2, 2, 1, '2025-05-02'),
(3, 3, 2, '2025-04-30'),
(4, 4, 2, '2025-04-28'),
(5, 5, 3, '2025-06-15');

INSERT IGNORE INTO Feedback (feedback_id, user_id, event_id, rating, comments, feedback_date) VALUES
(1, 3, 2, 4, 'Great insights!', '2025-05-16'),
(2, 4, 2, 5, 'Very informative.', '2025-05-16'),
(3, 2, 1, 3, 'Could be better.', '2025-06-11');

INSERT IGNORE INTO Resources (resource_id, event_id, resource_type, resource_url, uploaded_at) VALUES
(1, 2, 'pdf', 'https://portal.com/resources/tech_meetup_agenda.pdf', '2025-05-01 10:00:00'),
(2, 2, 'image', 'https://portal.com/resources/ai_poster.jpg', '2025-04-20 09:00:00'),
(3, 3, 'link', 'https://portal.com/resources/html5_docs', '2025-06-25 15:00:00');
'''

with open(os.path.join(folder, 'setup.sql'), 'w') as f:
    f.write(setup_sql)

queries = {
    '1.sql': """-- 1. User Upcoming Events
SELECT e.title, e.start_date, e.city, u.full_name
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
JOIN Users u ON r.user_id = u.user_id
WHERE e.status = 'upcoming' AND e.city = u.city
ORDER BY e.start_date;""",

    '2.sql': """-- 2. Top Rated Events
SELECT e.event_id, e.title, AVG(f.rating) as avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.event_id, e.title
HAVING COUNT(f.feedback_id) >= 10
ORDER BY avg_rating DESC;""",

    '3.sql': """-- 3. Inactive Users
SELECT u.user_id, u.full_name, u.email
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id AND r.registration_date >= CURDATE() - INTERVAL 90 DAY
WHERE r.registration_id IS NULL;""",

    '4.sql': """-- 4. Peak Session Hours
SELECT e.event_id, e.title, COUNT(s.session_id) as session_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
WHERE TIME(s.start_time) < '12:00:00' AND TIME(s.end_time) > '10:00:00'
GROUP BY e.event_id, e.title;""",

    '5.sql': """-- 5. Most Active Cities
SELECT u.city, COUNT(DISTINCT r.user_id) as distinct_users
FROM Registrations r
JOIN Users u ON r.user_id = u.user_id
GROUP BY u.city
ORDER BY distinct_users DESC
LIMIT 5;""",

    '6.sql': """-- 6. Event Resource Summary
SELECT e.event_id, e.title, 
       SUM(CASE WHEN r.resource_type = 'pdf' THEN 1 ELSE 0 END) AS pdf_count,
       SUM(CASE WHEN r.resource_type = 'image' THEN 1 ELSE 0 END) AS image_count,
       SUM(CASE WHEN r.resource_type = 'link' THEN 1 ELSE 0 END) AS link_count,
       COUNT(r.resource_id) AS total_resources
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title;""",

    '7.sql': """-- 7. Low Feedback Alerts
SELECT u.full_name, f.rating, f.comments, e.title as event_name
FROM Feedback f
JOIN Users u ON f.user_id = u.user_id
JOIN Events e ON f.event_id = e.event_id
WHERE f.rating < 3;""",

    '8.sql': """-- 8. Sessions per Upcoming Event
SELECT e.event_id, e.title, COUNT(s.session_id) as session_count
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE e.status = 'upcoming'
GROUP BY e.event_id, e.title;""",

    '9.sql': """-- 9. Organizer Event Summary
SELECT u.full_name as organizer_name, e.status, COUNT(e.event_id) as event_count
FROM Events e
JOIN Users u ON e.organizer_id = u.user_id
GROUP BY u.full_name, e.status;""",

    '10.sql': """-- 10. Feedback Gap
SELECT DISTINCT e.event_id, e.title
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
LEFT JOIN Feedback f ON e.event_id = f.event_id
WHERE f.feedback_id IS NULL;""",

    '11.sql': """-- 11. Daily New User Count
SELECT registration_date, COUNT(user_id) as new_users
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date;""",

    '12.sql': """-- 12. Event with Maximum Sessions
SELECT e.event_id, e.title, COUNT(s.session_id) as session_count
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title
ORDER BY session_count DESC
LIMIT 1;""",

    '13.sql': """-- 13. Average Rating per City
SELECT e.city, AVG(f.rating) as avg_rating
FROM Events e
JOIN Feedback f ON e.event_id = f.event_id
GROUP BY e.city;""",

    '14.sql': """-- 14. Most Registered Events
SELECT e.event_id, e.title, COUNT(r.registration_id) as total_registrations
FROM Events e
JOIN Registrations r ON e.event_id = r.event_id
GROUP BY e.event_id, e.title
ORDER BY total_registrations DESC
LIMIT 3;""",

    '15.sql': """-- 15. Event Session Time Conflict
SELECT s1.event_id, s1.title as session_1, s2.title as session_2
FROM Sessions s1
JOIN Sessions s2 ON s1.event_id = s2.event_id AND s1.session_id < s2.session_id
WHERE s1.start_time < s2.end_time AND s1.end_time > s2.start_time;""",

    '16.sql': """-- 16. Unregistered Active Users
SELECT u.user_id, u.full_name, u.email
FROM Users u
LEFT JOIN Registrations r ON u.user_id = r.user_id
WHERE u.registration_date >= CURDATE() - INTERVAL 30 DAY
AND r.registration_id IS NULL;""",

    '17.sql': """-- 17. Multi-Session Speakers
SELECT speaker_name, COUNT(session_id) as session_count
FROM Sessions
GROUP BY speaker_name
HAVING session_count > 1;""",

    '18.sql': """-- 18. Resource Availability Check
SELECT e.event_id, e.title
FROM Events e
LEFT JOIN Resources r ON e.event_id = r.event_id
WHERE r.resource_id IS NULL;""",

    '19.sql': """-- 19. Completed Events with Feedback Summary
SELECT e.event_id, e.title, 
       (SELECT COUNT(*) FROM Registrations r WHERE r.event_id = e.event_id) as total_registrations,
       (SELECT AVG(rating) FROM Feedback f WHERE f.event_id = e.event_id) as avg_rating
FROM Events e
WHERE e.status = 'completed';""",

    '20.sql': """-- 20. User Engagement Index
SELECT u.user_id, u.full_name, 
       (SELECT COUNT(DISTINCT event_id) FROM Registrations WHERE user_id = u.user_id) as events_attended,
       (SELECT COUNT(feedback_id) FROM Feedback WHERE user_id = u.user_id) as feedbacks_submitted
FROM Users u;""",

    '21.sql': """-- 21. Top Feedback Providers
SELECT u.user_id, u.full_name, COUNT(f.feedback_id) as feedback_count
FROM Users u
JOIN Feedback f ON u.user_id = f.user_id
GROUP BY u.user_id, u.full_name
ORDER BY feedback_count DESC
LIMIT 5;""",

    '22.sql': """-- 22. Duplicate Registrations Check
SELECT user_id, event_id, COUNT(registration_id) as registration_count
FROM Registrations
GROUP BY user_id, event_id
HAVING registration_count > 1;""",

    '23.sql': """-- 23. Registration Trends
SELECT DATE_FORMAT(registration_date, '%Y-%m') as registration_month, COUNT(registration_id) as count
FROM Registrations
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY registration_month
ORDER BY registration_month;""",

    '24.sql': """-- 24. Average Session Duration per Event
SELECT e.event_id, e.title, AVG(TIMESTAMPDIFF(MINUTE, s.start_time, s.end_time)) as avg_session_duration_minutes
FROM Events e
JOIN Sessions s ON e.event_id = s.event_id
GROUP BY e.event_id, e.title;""",

    '25.sql': """-- 25. Events Without Sessions
SELECT e.event_id, e.title
FROM Events e
LEFT JOIN Sessions s ON e.event_id = s.event_id
WHERE s.session_id IS NULL;"""
}

for filename, query in queries.items():
    with open(os.path.join(folder, filename), 'w') as f:
        f.write(query)
