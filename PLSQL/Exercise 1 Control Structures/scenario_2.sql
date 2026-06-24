DECLARE
    v_col_count NUMBER;

    CURSOR c_customers IS
        SELECT CustomerID, Balance, Name FROM Customers;
BEGIN
    SELECT COUNT(*)
    INTO v_col_count
    FROM user_tab_cols
    WHERE table_name = 'CUSTOMERS' AND column_name = 'ISVIP';

    IF v_col_count = 0 THEN
        EXECUTE IMMEDIATE 'ALTER TABLE Customers ADD (IsVIP VARCHAR2(5) DEFAULT ''FALSE'')';
        DBMS_OUTPUT.PUT_LINE('IsVIP column added to Customers table.');
    END IF;

    FOR r_cust IN c_customers LOOP
        IF r_cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = r_cust.CustomerID;
            DBMS_OUTPUT.PUT_LINE('Customer ' || r_cust.Name || ' (ID: ' || r_cust.CustomerID || ') promoted to VIP (Balance: $' || r_cust.Balance || ').');
        ELSE
            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = r_cust.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updates completed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/
