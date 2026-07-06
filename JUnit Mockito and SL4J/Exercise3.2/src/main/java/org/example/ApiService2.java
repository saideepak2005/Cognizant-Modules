package org.example;

public class ApiService2
{
    private RestClient2 restClient;

    public ApiService2(RestClient2 restClient)
    {
        this.restClient = restClient;
    }

    public String fetchData()
    {
        return "Fetched " + restClient.getResponse();
    }
}