CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    IF p_dob IS NULL THEN
        RETURN NULL;
    END IF;

    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);

    RETURN v_age;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in CalculateAge: ' || SQLERRM);
        RETURN NULL;
END CalculateAge;
/
