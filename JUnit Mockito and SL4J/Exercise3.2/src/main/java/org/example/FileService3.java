package org.example;

public class FileService3
{
    private FileReader3 fileReader;
    private FileWriter3 fileWriter;

    public FileService3(FileReader3 fileReader, FileWriter3 fileWriter)
    {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    public String processFile()
    {
        String data = fileReader.read();
        fileWriter.write(data);
        return "Processed " + data;
    }
}