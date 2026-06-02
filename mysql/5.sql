-- 5. Most Active Cities
SELECT u.city, COUNT(DISTINCT r.user_id) as distinct_users
FROM Registrations r
JOIN Users u ON r.user_id = u.user_id
GROUP BY u.city
ORDER BY distinct_users DESC
LIMIT 5;