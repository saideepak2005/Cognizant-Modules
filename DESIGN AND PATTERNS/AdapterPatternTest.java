interface PaymentProcessor
{
    void processPayment();
}

class PayPalGateway
{
    public void makePayment()
    {
        System.out.println("Payment processed through PayPal");
    }
}

class StripeGateway
{
    public void payAmount()
    {
        System.out.println("Payment processed through Stripe");
    }
}

class PayPalAdapter implements PaymentProcessor
{
    private PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway gateway)
    {
        this.gateway = gateway;
    }

    public void processPayment()
    {
        gateway.makePayment();
    }
}

class StripeAdapter implements PaymentProcessor
{
    private StripeGateway gateway;

    public StripeAdapter(StripeGateway gateway)
    {
        this.gateway = gateway;
    }

    public void processPayment()
    {
        gateway.payAmount();
    }
}

public class AdapterPatternTest
{
    public static void main(String[] args)
    {
        PaymentProcessor p1 =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor p2 =
                new StripeAdapter(new StripeGateway());

        p1.processPayment();
        p2.processPayment();
    }
}