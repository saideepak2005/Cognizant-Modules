public class StrategyPatternExample
{
    public static void main(String[] args)
    {
        PaymentContext context =
                new PaymentContext();

        context.setPaymentStrategy(
                new CreditCardPayment());

        context.executePayment(5000);

        context.setPaymentStrategy(
                new PayPalPayment());

        context.executePayment(2500);
    }
}
class PaymentContext
{
    private PaymentStrategy strategy;

    public void setPaymentStrategy(
            PaymentStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void executePayment(double amount)
    {
        strategy.pay(amount);
    }
}
class PayPalPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println(
            "Paid ₹" + amount +
            " using PayPal"
        );
    }
}
class CreditCardPayment implements PaymentStrategy
{
    @Override
    public void pay(double amount)
    {
        System.out.println(
            "Paid ₹" + amount +
            " using Credit Card"
        );
    }
}
interface PaymentStrategy
{
    void pay(double amount);
}