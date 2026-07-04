CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_employee_id IN Employees.EmployeeID%TYPE,
        p_name        IN Employees.Name%TYPE,
        p_position    IN Employees.Position%TYPE,
        p_salary      IN Employees.Salary%TYPE,
        p_department  IN Employees.Department%TYPE,
        p_hire_date   IN Employees.HireDate%TYPE
    );

    PROCEDURE UpdateEmployeeDetails (
        p_employee_id IN Employees.EmployeeID%TYPE,
        p_name        IN Employees.Name%TYPE,
        p_position    IN Employees.Position%TYPE,
        p_salary      IN Employees.Salary%TYPE,
        p_department  IN Employees.Department%TYPE
    );

    FUNCTION CalculateAnnualSalary (
        p_employee_id IN Employees.EmployeeID%TYPE
    ) RETURN NUMBER;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee (
        p_employee_id IN Employees.EmployeeID%TYPE,
        p_name        IN Employees.Name%TYPE,
        p_position    IN Employees.Position%TYPE,
        p_salary      IN Employees.Salary%TYPE,
        p_department  IN Employees.Department%TYPE,
        p_hire_date   IN Employees.HireDate%TYPE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employee_id, p_name, p_position, p_salary, p_department, p_hire_date);

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('EmployeeManagement: Hired new employee ' || p_name || ' (ID: ' || p_employee_id || ').');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('EmployeeManagement Error: Employee ID ' || p_employee_id || ' already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('EmployeeManagement Error: HireEmployee failed. ' || SQLERRM);
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails (
        p_employee_id IN Employees.EmployeeID%TYPE,
        p_name        IN Employees.Name%TYPE,
        p_position    IN Employees.Position%TYPE,
        p_salary      IN Employees.Salary%TYPE,
        p_department  IN Employees.Department%TYPE
    ) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name,
            Position = p_position,
            Salary = p_salary,
            Department = p_department
        WHERE EmployeeID = p_employee_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('EmployeeManagement Warning: Employee ID ' || p_employee_id || ' does not exist.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('EmployeeManagement: Details updated successfully for Employee ID ' || p_employee_id || '.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('EmployeeManagement Error: UpdateEmployeeDetails failed. ' || SQLERRM);
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary (
        p_employee_id IN Employees.EmployeeID%TYPE
    ) RETURN NUMBER IS
        v_salary Employees.Salary%TYPE;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;

        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('EmployeeManagement Warning: Employee ID ' || p_employee_id || ' not found.');
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('EmployeeManagement Error: CalculateAnnualSalary failed. ' || SQLERRM);
            RETURN NULL;
    END CalculateAnnualSalary;

END EmployeeManagement;
/
