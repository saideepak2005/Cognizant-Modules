CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance Accounts.Balance%TYPE;
BEGIN
    IF :new.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transaction amount must be strictly greater than zero.');
    END IF;

    IF :new.TransactionType = 'Deposit' THEN
        NULL;

    ELSIF :new.TransactionType = 'Withdrawal' THEN
        SELECT Balance INTO v_balance
        FROM Accounts
        WHERE AccountID = :new.AccountID;

        IF :new.Amount > v_balance THEN
            RAISE_APPLICATION_ERROR(-20002, 'Withdrawal rejected: Insufficient funds. ' ||
                                            'Requested: $' || :new.Amount ||
                                            ' | Current Balance: $' || v_balance);
        END IF;

    ELSE
        RAISE_APPLICATION_ERROR(-20003, 'Transaction rejected: Invalid Transaction Type. ' ||
                                        'Must be either ''Deposit'' or ''Withdrawal''.');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20004, 'Transaction rejected: Account ID ' || :new.AccountID || ' does not exist.');
    WHEN OTHERS THEN
        IF SQLCODE IN (-20001, -20002, -20003, -20004) THEN
            RAISE;
        ELSE
            RAISE_APPLICATION_ERROR(-20099, 'Transaction rules enforcement error: ' || SQLERRM);
        END IF;
END;
/
