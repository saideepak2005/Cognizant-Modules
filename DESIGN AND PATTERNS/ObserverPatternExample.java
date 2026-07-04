import java.util.*;

interface Observer
{
    void update(String stockName, double price);
}


interface Stock
{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock
{
    private List<Observer> observers = new ArrayList<>();

    private String stockName;
    private double price;

    @Override
    public void registerObserver(Observer o)
    {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o)
    {
        observers.remove(o);
    }

    @Override
    public void notifyObservers()
    {
        for (Observer o : observers)
        {
            o.update(stockName, price);
        }
    }

    public void setStockPrice(String stockName, double price)
    {
        this.stockName = stockName;
        this.price = price;

        System.out.println("\nStock Updated");
        notifyObservers();
    }
}

// Concrete Observer 1
class MobileApp implements Observer
{
    private String user;

    public MobileApp(String user)
    {
        this.user = user;
    }

    @Override
    public void update(String stockName, double price)
    {
        System.out.println(
            "Mobile App [" + user + "] : "
            + stockName + " Price = ₹" + price
        );
    }
}

class WebApp implements Observer
{
    private String user;

    public WebApp(String user)
    {
        this.user = user;
    }

    @Override
    public void update(String stockName, double price)
    {
        System.out.println(
            "Web App [" + user + "] : "
            + stockName + " Price = ₹" + price
        );
    }
}

public class ObserverPatternExample
{
    public static void main(String[] args)
    {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp("Sai");
        Observer web = new WebApp("Deepak");

        market.registerObserver(mobile);
        market.registerObserver(web);

        market.setStockPrice("TCS", 3500);

        market.removeObserver(web);

        market.setStockPrice("TCS", 3600);
    }
}