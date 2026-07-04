CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN Customers.CustomerID%TYPE,
    p_name        IN Customers.Name%TYPE,
    p_dob         IN Customers.DOB%TYPE,
    p_balance     IN Customers.Balance%TYPE
) AS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Success: Customer with ID ' || p_customer_id || ' (' || p_name || ') has been successfully added.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' already exists. Insertion prevented.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Unexpected exception occurred while adding customer. ' || SQLERRM);
END AddNewCustomer;
/
