CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer (
        p_customer_id IN Customers.CustomerID%TYPE,
        p_name        IN Customers.Name%TYPE,
        p_dob         IN Customers.DOB%TYPE,
        p_balance     IN Customers.Balance%TYPE
    );

    PROCEDURE UpdateCustomerDetails (
        p_customer_id IN Customers.CustomerID%TYPE,
        p_name        IN Customers.Name%TYPE,
        p_dob         IN Customers.DOB%TYPE
    );

    FUNCTION GetCustomerBalance (
        p_customer_id IN Customers.CustomerID%TYPE
    ) RETURN NUMBER;

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer (
        p_customer_id IN Customers.CustomerID%TYPE,
        p_name        IN Customers.Name%TYPE,
        p_dob         IN Customers.DOB%TYPE,
        p_balance     IN Customers.Balance%TYPE
    ) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('CustomerManagement: Success adding customer ID ' || p_customer_id || ' (' || p_name || ').');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('CustomerManagement Error: Customer ID ' || p_customer_id || ' already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('CustomerManagement Error: AddCustomer failed. ' || SQLERRM);
    END AddCustomer;

    PROCEDURE UpdateCustomerDetails (
        p_customer_id IN Customers.CustomerID%TYPE,
        p_name        IN Customers.Name%TYPE,
        p_dob         IN Customers.DOB%TYPE
    ) IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            DOB = p_dob,
            LastModified = SYSDATE
        WHERE CustomerID = p_customer_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('CustomerManagement Warning: Customer ID ' || p_customer_id || ' does not exist.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('CustomerManagement: Customer ID ' || p_customer_id || ' details updated successfully.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('CustomerManagement Error: UpdateCustomerDetails failed. ' || SQLERRM);
    END UpdateCustomerDetails;

    FUNCTION GetCustomerBalance (
        p_customer_id IN Customers.CustomerID%TYPE
    ) RETURN NUMBER IS
        v_balance Customers.Balance%TYPE;
    BEGIN
        SELECT Balance INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customer_id;

        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('CustomerManagement Warning: Customer ID ' || p_customer_id || ' not found.');
            RETURN NULL;
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('CustomerManagement Error: GetCustomerBalance failed. ' || SQLERRM);
            RETURN NULL;
    END GetCustomerBalance;

END CustomerManagement;
/
