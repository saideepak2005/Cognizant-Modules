CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_source_acc IN Accounts.AccountID%TYPE,
    p_dest_acc   IN Accounts.AccountID%TYPE,
    p_amount     IN NUMBER
) AS
    v_source_bal Accounts.Balance%TYPE;
    v_dest_bal   Accounts.Balance%TYPE;

    insufficient_funds EXCEPTION;
    invalid_amount EXCEPTION;
    same_account EXCEPTION;
BEGIN
    IF p_amount <= 0 THEN
        RAISE invalid_amount;
    END IF;

    IF p_source_acc = p_dest_acc THEN
        RAISE same_account;
    END IF;

    SELECT Balance INTO v_source_bal
    FROM Accounts
    WHERE AccountID = p_source_acc
    FOR UPDATE;

    SELECT Balance INTO v_dest_bal
    FROM Accounts
    WHERE AccountID = p_dest_acc
    FOR UPDATE;

    IF v_source_bal < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_source_acc;

    UPDATE Accounts
    SET Balance = Balance + p_amount,
        LastModified = SYSDATE
    WHERE AccountID = p_dest_acc;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transaction Success: Transferred $' || p_amount ||
                         ' from Account ' || p_source_acc || ' to Account ' || p_dest_acc);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: Account ID not found. Ensure both source and destination accounts exist.');
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: Insufficient funds in source account (ID: ' ||
                             p_source_acc || '). Available: $' || v_source_bal);
    WHEN invalid_amount THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: Transfer amount must be greater than zero.');
    WHEN same_account THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: Source and destination accounts cannot be the same.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: An unexpected error occurred. Error Code: ' ||
                             SQLCODE || ' | Error Message: ' || SQLERRM);
END SafeTransferFunds;
/
