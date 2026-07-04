CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department       IN Employees.Department%TYPE,
    p_bonus_percentage IN NUMBER
) AS
    v_rows_updated NUMBER := 0;
    invalid_bonus EXCEPTION;
BEGIN
    IF p_bonus_percentage < 0 THEN
        RAISE invalid_bonus;
    END IF;

    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100)
    WHERE Department = p_department;

    v_rows_updated := SQL%ROWCOUNT;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus update completed for Department: ' || p_department);
    DBMS_OUTPUT.PUT_LINE('Bonus applied: ' || p_bonus_percentage || '% | Employees updated: ' || v_rows_updated);

EXCEPTION
    WHEN invalid_bonus THEN
        DBMS_OUTPUT.PUT_LINE('Error: Bonus percentage cannot be negative.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Failed to apply employee bonuses. ' || SQLERRM);
END UpdateEmployeeBonus;
/
