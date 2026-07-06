package org.example;

public class MyService3
{
    private ExternalApi3 api;

    public MyService3(ExternalApi3 api)
    {
        this.api = api;
    }

    public void process()
    {
        api.sendData("Mockito");
    }
}