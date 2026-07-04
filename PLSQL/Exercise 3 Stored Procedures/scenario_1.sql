CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
    v_rows_updated NUMBER := 0;
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';

    v_rows_updated := SQL%ROWCOUNT;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processing completed successfully.');
    DBMS_OUTPUT.PUT_LINE('Number of savings accounts updated: ' || v_rows_updated);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Interest calculation failed. ' || SQLERRM);
END ProcessMonthlyInterest;
/
