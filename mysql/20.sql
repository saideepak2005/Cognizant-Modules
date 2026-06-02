-- 20. User Engagement Index
SELECT u.user_id, u.full_name, 
       (SELECT COUNT(DISTINCT event_id) FROM Registrations WHERE user_id = u.user_id) as events_attended,
       (SELECT COUNT(feedback_id) FROM Feedback WHERE user_id = u.user_id) as feedbacks_submitted
FROM Users u;