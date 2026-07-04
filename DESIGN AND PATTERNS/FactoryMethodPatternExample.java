public class FactoryMethodPatternExample {
    public static void main(String []args)
    {
        DocumentFactory pdfFactory = new Pdffactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();

        DocumentFactory wordFactory = new Wordfactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.open();

        DocumentFactory excelFactory = new Excelfactory();
        Document excelDocument = excelFactory.createDocument();
        excelDocument.open();
    }
    
}

interface Document
{
    void open();
}
abstract class DocumentFactory
{
    abstract Document createDocument();
}

class PDFDocument implements Document
{
    public void open()
    {
        System.out.println("Opening PDF document");
    }
}

class WordDocument implements Document
{
    public void open()
    {
        System.out.println("Opening Word document");
    }
}

class ExcelDocument implements Document
{
    public void open()
    {
        System.out.println("Opening Excel document");
    }
}

class Pdffactory extends DocumentFactory
{
    Document createDocument(){
        return new PDFDocument();
    }
}

class Wordfactory extends DocumentFactory
{
    Document createDocument(){
        return new WordDocument();
    }
}

class Excelfactory extends DocumentFactory
{
    Document createDocument(){
        return new ExcelDocument();
    }
}
