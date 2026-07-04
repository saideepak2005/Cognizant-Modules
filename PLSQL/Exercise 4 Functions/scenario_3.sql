CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN Accounts.AccountID%TYPE,
    p_amount     IN NUMBER
) RETURN BOOLEAN IS
    v_balance Accounts.Balance%TYPE;
BEGIN
    IF p_amount < 0 THEN
        RETURN FALSE;
    END IF;

    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in HasSufficientBalance: ' || SQLERRM);
        RETURN FALSE;
END HasSufficientBalance;
/
