CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount (
        p_account_id   IN Accounts.AccountID%TYPE,
        p_customer_id  IN Accounts.CustomerID%TYPE,
        p_account_type IN Accounts.AccountType%TYPE,
        p_initial_bal  IN Accounts.Balance%TYPE
    );

    PROCEDURE CloseAccount (
        p_account_id   IN Accounts.AccountID%TYPE
    );

    FUNCTION GetTotalBalance (
        p_customer_id  IN Accounts.CustomerID%TYPE
    ) RETURN NUMBER;

END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount (
        p_account_id   IN Accounts.AccountID%TYPE,
        p_customer_id  IN Accounts.CustomerID%TYPE,
        p_account_type IN Accounts.AccountType%TYPE,
        p_initial_bal  IN Accounts.Balance%TYPE
    ) IS
        v_cust_exists  NUMBER;
    BEGIN
        SELECT COUNT(*) INTO v_cust_exists FROM Customers WHERE CustomerID = p_customer_id;

        IF v_cust_exists = 0 THEN
            DBMS_OUTPUT.PUT_LINE('AccountOperations Error: Cannot open account. Customer ID ' || p_customer_id || ' does not exist.');
            RETURN;
        END IF;

        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_initial_bal, SYSDATE);

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('AccountOperations: Account ID ' || p_account_id || ' opened successfully for Customer ' || p_customer_id || '.');
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('AccountOperations Error: Account ID ' || p_account_id || ' already exists.');
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('AccountOperations Error: OpenAccount failed. ' || SQLERRM);
    END OpenAccount;

    PROCEDURE CloseAccount (
        p_account_id   IN Accounts.AccountID%TYPE
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_account_id;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('AccountOperations Warning: Account ID ' || p_account_id || ' not found.');
        ELSE
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('AccountOperations: Account ID ' || p_account_id || ' closed successfully.');
        END IF;
    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('AccountOperations Error: CloseAccount failed. ' || SQLERRM);
    END CloseAccount;

    FUNCTION GetTotalBalance (
        p_customer_id  IN Accounts.CustomerID%TYPE
    ) RETURN NUMBER IS
        v_total_balance Accounts.Balance%TYPE := 0;
        v_cust_exists   NUMBER;
    BEGIN
        SELECT COUNT(*) INTO v_cust_exists FROM Customers WHERE CustomerID = p_customer_id;

        IF v_cust_exists = 0 THEN
            DBMS_OUTPUT.PUT_LINE('AccountOperations Warning: Customer ID ' || p_customer_id || ' not found.');
            RETURN NULL;
        END IF;

        SELECT SUM(Balance) INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN NVL(v_total_balance, 0);
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('AccountOperations Error: GetTotalBalance failed. ' || SQLERRM);
            RETURN NULL;
    END GetTotalBalance;

END AccountOperations;
/
