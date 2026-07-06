package org.example;

public class Service1
{
    private Repository1 repository;

    public Service1(Repository1 repository)
    {
        this.repository = repository;
    }

    public String processData()
    {
        return "Processed " + repository.getData();
    }
}