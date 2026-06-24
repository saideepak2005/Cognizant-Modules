DECLARE
    v_annual_fee CONSTANT NUMBER := 50.00;

    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance FROM Accounts FOR UPDATE;

    v_account_id Accounts.AccountID%TYPE;
    v_balance    Accounts.Balance%TYPE;
    v_count      NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- STARTING ANNUAL MAINTENANCE FEE DEPRECIATION ---');

    OPEN ApplyAnnualFee;
    LOOP
        FETCH ApplyAnnualFee INTO v_account_id, v_balance;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_annual_fee,
            LastModified = SYSDATE
        WHERE CURRENT OF ApplyAnnualFee;

        DBMS_OUTPUT.PUT_LINE('Processed Account: ' || v_account_id ||
                             ' | Old Balance: $' || v_balance ||
                             ' | New Balance: $' || (v_balance - v_annual_fee));
        v_count := v_count + 1;
    END LOOP;
    CLOSE ApplyAnnualFee;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('--- ANNUAL MAINTENANCE FEE DEPRECIATION COMPLETED ---');
    DBMS_OUTPUT.PUT_LINE('Total Accounts processed: ' || v_count);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        IF ApplyAnnualFee%ISOPEN THEN
            CLOSE ApplyAnnualFee;
        END IF;
        DBMS_OUTPUT.PUT_LINE('Error occurred during annual fee processing: ' || SQLERRM);
END;
/
