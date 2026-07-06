package org.example;

public class Service5
{
    private Repository5 repository;

    public Service5(Repository5 repository)
    {
        this.repository = repository;
    }

    public String processData()
    {
        return "Processed " + repository.getData();
    }
}