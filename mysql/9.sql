-- 9. Organizer Event Summary
SELECT u.full_name as organizer_name, e.status, COUNT(e.event_id) as event_count
FROM Events e
JOIN Users u ON e.organizer_id = u.user_id
GROUP BY u.full_name, e.status;