package org.example;

public class MyService6
{
    private ExternalApi6 api;

    public MyService6(ExternalApi6 api)
    {
        this.api = api;
    }

    public void process()
    {
        api.firstMethod();
        api.secondMethod();
    }
}