DECLARE
    v_table_exists NUMBER;
    v_seq_exists NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_table_exists FROM user_tables WHERE table_name = 'AUDITLOG';
    IF v_table_exists = 0 THEN
        EXECUTE IMMEDIATE 'CREATE TABLE AuditLog (
            AuditID NUMBER PRIMARY KEY,
            TransactionID NUMBER,
            AccountID NUMBER,
            TransactionDate DATE,
            Amount NUMBER,
            TransactionType VARCHAR2(10),
            LogDate DATE
        )';
        DBMS_OUTPUT.PUT_LINE('Table AuditLog created.');
    END IF;

    SELECT COUNT(*) INTO v_seq_exists FROM user_sequences WHERE sequence_name = 'AUDITLOG_SEQ';
    IF v_seq_exists = 0 THEN
        EXECUTE IMMEDIATE 'CREATE SEQUENCE AuditLog_Seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE';
        DBMS_OUTPUT.PUT_LINE('Sequence AuditLog_Seq created.');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        AuditID,
        TransactionID,
        AccountID,
        TransactionDate,
        Amount,
        TransactionType,
        LogDate
    ) VALUES (
        AuditLog_Seq.NEXTVAL,
        :new.TransactionID,
        :new.AccountID,
        :new.TransactionDate,
        :new.Amount,
        :new.TransactionType,
        SYSDATE
    );
END;
/
