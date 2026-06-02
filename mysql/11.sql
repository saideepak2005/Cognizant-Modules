-- 11. Daily New User Count
SELECT registration_date, COUNT(user_id) as new_users
FROM Users
WHERE registration_date >= CURDATE() - INTERVAL 7 DAY
GROUP BY registration_date;