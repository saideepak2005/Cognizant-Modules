CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount    IN NUMBER,
    p_interest_rate  IN NUMBER,
    p_duration_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_rate   NUMBER;
    v_total_months   NUMBER;
    v_installment    NUMBER;
BEGIN
    IF p_loan_amount <= 0 OR p_interest_rate < 0 OR p_duration_years <= 0 THEN
        RETURN 0;
    END IF;

    v_monthly_rate := (p_interest_rate / 12) / 100;
    v_total_months := p_duration_years * 12;

    IF v_monthly_rate = 0 THEN
        v_installment := p_loan_amount / v_total_months;
    ELSE
        v_installment := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_total_months) /
                         (POWER(1 + v_monthly_rate, v_total_months) - 1);
    END IF;

    RETURN ROUND(v_installment, 2);
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in CalculateMonthlyInstallment: ' || SQLERRM);
        RETURN NULL;
END CalculateMonthlyInstallment;
/
