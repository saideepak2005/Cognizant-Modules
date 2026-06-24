DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, LoanAmount, InterestRate FROM Loans FOR UPDATE;

    v_loan_id     Loans.LoanID%TYPE;
    v_loan_amount Loans.LoanAmount%TYPE;
    v_old_rate    Loans.InterestRate%TYPE;
    v_new_rate    Loans.InterestRate%TYPE;
    v_count       NUMBER := 0;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- STARTING INTEREST RATE ADJUSTMENT POLICY ---');
    DBMS_OUTPUT.PUT_LINE('Policy:');
    DBMS_OUTPUT.PUT_LINE(' - Loan Amount > $10,000  : Reduce Interest Rate by 1.0%');
    DBMS_OUTPUT.PUT_LINE(' - Loan Amount <= $10,000 : Reduce Interest Rate by 0.5%');
    DBMS_OUTPUT.PUT_LINE('------------------------------------------------');

    OPEN UpdateLoanInterestRates;
    LOOP
        FETCH UpdateLoanInterestRates INTO v_loan_id, v_loan_amount, v_old_rate;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        IF v_loan_amount > 10000 THEN
            v_new_rate := v_old_rate - 1.0;
        ELSE
            v_new_rate := v_old_rate - 0.5;
        END IF;

        IF v_new_rate < 0 THEN
            v_new_rate := 0;
        END IF;

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loan_id ||
                             ' | Amount: $' || TO_CHAR(v_loan_amount, '999,999') ||
                             ' | Old Rate: ' || v_old_rate || '% | New Rate: ' || v_new_rate || '%');
        v_count := v_count + 1;
    END LOOP;
    CLOSE UpdateLoanInterestRates;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('------------------------------------------------');
    DBMS_OUTPUT.PUT_LINE('Interest rate update process completed.');
    DBMS_OUTPUT.PUT_LINE('Total loans updated: ' || v_count);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        IF UpdateLoanInterestRates%ISOPEN THEN
            CLOSE UpdateLoanInterestRates;
        END IF;
        DBMS_OUTPUT.PUT_LINE('Error: Interest rate adjustment failed. ' || SQLERRM);
END;
/
