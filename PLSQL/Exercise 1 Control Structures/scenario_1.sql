DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, DOB, Name FROM Customers;

    v_age NUMBER;
    v_discount_applied BOOLEAN;
BEGIN
    FOR r_cust IN c_customers LOOP
        IF r_cust.DOB IS NOT NULL THEN
            v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, r_cust.DOB) / 12);

            IF v_age > 60 THEN
                v_discount_applied := FALSE;

                UPDATE Loans
                SET InterestRate = InterestRate - 1
                WHERE CustomerID = r_cust.CustomerID;

                IF SQL%ROWCOUNT > 0 THEN
                    DBMS_OUTPUT.PUT_LINE('Customer ' || r_cust.Name || ' (ID: ' || r_cust.CustomerID ||
                                         ', Age: ' || v_age || ') received a 1% discount on their loan interest rates.');
                ELSE
                    DBMS_OUTPUT.PUT_LINE('Customer ' || r_cust.Name || ' (ID: ' || r_cust.CustomerID ||
                                         ', Age: ' || v_age || ') has no active loans.');
                END IF;
            END IF;
        END IF;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Discount processing completed successfully.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/
