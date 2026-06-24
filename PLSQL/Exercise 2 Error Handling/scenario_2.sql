CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN Employees.EmployeeID%TYPE,
    p_percentage  IN NUMBER
) AS
    v_old_salary Employees.Salary%TYPE;
    v_new_salary Employees.Salary%TYPE;

    invalid_percentage EXCEPTION;
BEGIN
    IF p_percentage < -100 THEN
        RAISE invalid_percentage;
    END IF;

    SELECT Salary INTO v_old_salary
    FROM Employees
    WHERE EmployeeID = p_employee_id;

    v_new_salary := v_old_salary * (1 + p_percentage / 100);

    UPDATE Employees
    SET Salary = v_new_salary
    WHERE EmployeeID = p_employee_id;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Success: Salary for Employee ID ' || p_employee_id ||
                         ' increased by ' || p_percentage || '%. Old Salary: $' || v_old_salary ||
                         ' | New Salary: $' || v_new_salary);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist in the Employees database.');
    WHEN invalid_percentage THEN
        DBMS_OUTPUT.PUT_LINE('Error: Salary reduction percentage cannot be less than -100%.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Unexpected exception occurred while updating salary. ' || SQLERRM);
END UpdateSalary;
/
