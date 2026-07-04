DECLARE
    CURSOR c_due_loans IS
        SELECT l.LoanID, c.Name, l.EndDate, l.LoanAmount
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

    v_loan_id      Loans.LoanID%TYPE;
    v_cust_name    Customers.Name%TYPE;
    v_end_date     Loans.EndDate%TYPE;
    v_loan_amount  Loans.LoanAmount%TYPE;
    v_records_found BOOLEAN := FALSE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- LOAN DUE REMINDERS (NEXT 30 DAYS) ---');

    OPEN c_due_loans;
    LOOP
        FETCH c_due_loans INTO v_loan_id, v_cust_name, v_end_date, v_loan_amount;
        EXIT WHEN c_due_loans%NOTFOUND;

        v_records_found := TRUE;
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_cust_name || ', your loan (ID: ' || v_loan_id ||
                             ') with outstanding balance $' || v_loan_amount ||
                             ' is due on ' || TO_CHAR(v_end_date, 'YYYY-MM-DD') ||
                             '. Please arrange for repayment.');
    END LOOP;
    CLOSE c_due_loans;

    IF NOT v_records_found THEN
        DBMS_OUTPUT.PUT_LINE('No loans are due within the next 30 days.');
    END IF;

    DBMS_OUTPUT.PUT_LINE('-----------------------------------------');
EXCEPTION
    WHEN OTHERS THEN
        IF c_due_loans%ISOPEN THEN
            CLOSE c_due_loans;
        END IF;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/
