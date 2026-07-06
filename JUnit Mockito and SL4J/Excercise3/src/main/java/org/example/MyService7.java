package org.example;

public class MyService7
{
    private ExternalApi7 api;

    public MyService7(ExternalApi7 api)
    {
        this.api = api;
    }

    public void process()
    {
        api.sendData();
    }
}