-- 23. Registration Trends
SELECT DATE_FORMAT(registration_date, '%Y-%m') as registration_month, COUNT(registration_id) as count
FROM Registrations
WHERE registration_date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH)
GROUP BY registration_month
ORDER BY registration_month;