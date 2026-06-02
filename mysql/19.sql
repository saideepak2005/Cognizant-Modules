-- 19. Completed Events with Feedback Summary
SELECT e.event_id, e.title, 
       (SELECT COUNT(*) FROM Registrations r WHERE r.event_id = e.event_id) as total_registrations,
       (SELECT AVG(rating) FROM Feedback f WHERE f.event_id = e.event_id) as avg_rating
FROM Events e
WHERE e.status = 'completed';