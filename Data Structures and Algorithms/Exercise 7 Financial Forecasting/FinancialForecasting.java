package exercise7;

public class FinancialForecasting {

    public static double calculateFutureValueRecursive(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValueRecursive(presentValue, rate, years - 1) * (1 + rate);
    }

    public static double calculateFutureValueVarying(double presentValue, double[] rates, int currentYear) {
        if (currentYear == rates.length) {
            return presentValue;
        }
        double updatedValue = presentValue * (1 + rates[currentYear]);
        return calculateFutureValueVarying(updatedValue, rates, currentYear + 1);
    }

    public static double calculateFutureValueIterative(double presentValue, double rate, int years) {
        double futureValue = presentValue;
        for (int i = 0; i < years; i++) {
            futureValue *= (1 + rate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double annualRate = 0.05;
        int years = 10;

        System.out.println("--- Financial Forecasting (Constant Growth) ---");
        System.out.println("Present Value: $" + presentValue);
        System.out.println("Annual Interest Rate: " + (annualRate * 100) + "%");
        System.out.println("Forecasting Period: " + years + " years");

        double fvRecursive = calculateFutureValueRecursive(presentValue, annualRate, years);
        System.out.printf("\nFuture Value (Recursive): $%.2f\n", fvRecursive);

        double fvIterative = calculateFutureValueIterative(presentValue, annualRate, years);
        System.out.printf("Future Value (Iterative / Optimized): $%.2f\n", fvIterative);

        System.out.println("\n--- Financial Forecasting (Varying Growth Rates) ---");
        double[] varyingRates = {0.03, 0.05, 0.04, -0.02, 0.06};
        System.out.print("Growth Rates per year: ");
        for (double r : varyingRates) {
            System.out.print((r * 100) + "% ");
        }
        System.out.println();

        double fvVarying = calculateFutureValueVarying(presentValue, varyingRates, 0);
        System.out.printf("Future Value (Varying Rates Recursive): $%.2f\n", fvVarying);
    }
}
