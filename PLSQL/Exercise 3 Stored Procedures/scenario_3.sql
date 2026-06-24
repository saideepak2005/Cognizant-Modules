CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_acc IN Accounts.AccountID%TYPE,
    p_dest_acc   IN Accounts.AccountID%TYPE,
    p_amount     IN NUMBER
) AS
    v_source_bal Accounts.Balance%TYPE;

    insufficient_funds EXCEPTION;
    invalid_transfer_amount EXCEPTION;
    same_account EXCEPTION;
BEGIN
    IF p_amount <= 0 THEN
        RAISE invalid_transfer_amount;
    END IF;

    IF p_source_acc = p_dest_acc THEN
        RAISE same_account;
    END IF;

    SELECT Balance INTO v_source_bal
    FROM Accounts
    WHERE AccountID = p_source_acc
    FOR UPDATE;

    DECLARE
        v_dest_exists NUMBER;
    BEGIN
        SELECT 1 INTO v_dest_exists FROM Accounts WHERE AccountID = p_dest_acc;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE_APPLICATION_ERROR(-20005, 'Destination account does not exist.');
    END;

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
    DBMS_OUTPUT.PUT_LINE('Success: Transferred $' || p_amount || ' from Account ' || p_source_acc || ' to Account ' || p_dest_acc || '.');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Source account (ID: ' || p_source_acc || ') does not exist.');
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in source account (ID: ' || p_source_acc || '). Available: $' || v_source_bal);
    WHEN invalid_transfer_amount THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Transfer amount must be positive.');
    WHEN same_account THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Source and destination accounts cannot be the same.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Transfer failed. Details: ' || SQLERRM);
END TransferFunds;
/
