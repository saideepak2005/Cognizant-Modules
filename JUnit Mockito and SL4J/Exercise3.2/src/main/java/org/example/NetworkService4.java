package org.example;

public class NetworkService4
{
    private NetworkClient4 networkClient;

    public NetworkService4(NetworkClient4 networkClient)
    {
        this.networkClient = networkClient;
    }

    public String connectToServer()
    {
        return "Connected to " + networkClient.connect();
    }
}