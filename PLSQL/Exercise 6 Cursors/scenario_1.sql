DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.CustomerID,
               c.Name AS CustomerName,
               a.AccountID,
               t.TransactionID,
               t.TransactionDate,
               t.Amount,
               t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE TRUNC(t.TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
        ORDER BY c.CustomerID, a.AccountID, t.TransactionDate;

    v_tx GenerateMonthlyStatements%ROWTYPE;

    v_prev_customer_id Customers.CustomerID%TYPE := -1;
    v_cust_tx_count NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('========================================================================');
    DBMS_OUTPUT.PUT_LINE('              MONTHLY ACCOUNT STATEMENTS FOR: ' || TO_CHAR(SYSDATE, 'MONTH YYYY'));
    DBMS_OUTPUT.PUT_LINE('========================================================================');

    OPEN GenerateMonthlyStatements;
    LOOP
        FETCH GenerateMonthlyStatements INTO v_tx;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        IF v_prev_customer_id <> v_tx.CustomerID THEN
            IF v_prev_customer_id <> -1 THEN
                DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------------------');
            END IF;
            DBMS_OUTPUT.PUT_LINE('Customer: ' || v_tx.CustomerName || ' (ID: ' || v_tx.CustomerID || ')');
            v_prev_customer_id := v_tx.CustomerID;
            v_cust_tx_count := 0;
        END IF;

        DBMS_OUTPUT.PUT_LINE('  - TxID: ' || v_tx.TransactionID ||
                             ' | Account: ' || v_tx.AccountID ||
                             ' | Date: ' || TO_CHAR(v_tx.TransactionDate, 'YYYY-MM-DD') ||
                             ' | Type: ' || RPAD(v_tx.TransactionType, 10) ||
                             ' | Amount: $' || TO_CHAR(v_tx.Amount, '99,999.00'));
        v_cust_tx_count := v_cust_tx_count + 1;
    END LOOP;

    IF v_prev_customer_id <> -1 THEN
        DBMS_OUTPUT.PUT_LINE('------------------------------------------------------------------------');
    ELSE
        DBMS_OUTPUT.PUT_LINE('No transactions found for the current month.');
    END IF;

    CLOSE GenerateMonthlyStatements;
    DBMS_OUTPUT.PUT_LINE('Statement generation process finished.');
    DBMS_OUTPUT.PUT_LINE('========================================================================');
EXCEPTION
    WHEN OTHERS THEN
        IF GenerateMonthlyStatements%ISOPEN THEN
            CLOSE GenerateMonthlyStatements;
        END IF;
        DBMS_OUTPUT.PUT_LINE('Error: Failed to generate monthly statements. ' || SQLERRM);
END;
/
