package org.example;

public class MyService2 {

    private ExternalApi2 api;

    public MyService2(ExternalApi2 api) {
        this.api = api;
    }

    public void process() {
        api.FindData("Hello Mockito");
    }

}