public class ProxyPatternExample
{
    public static void main(String[] args)
    {
        Image image = new ProxyImage("photo.jpg");

        System.out.println("First Call:");
        image.display();

        System.out.println();

        System.out.println("Second Call:");
        image.display();
    }
}
class ProxyImage implements Image
{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public void display()
    {
        if(realImage == null)
        {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}
class RealImage implements Image
{
    private String fileName;

    public RealImage(String fileName)
    {
        this.fileName = fileName;
        loadFromServer();
    }

    private void loadFromServer()
    {
        System.out.println("Loading image from remote server: " + fileName);
    }

    @Override
    public void display()
    {
        System.out.println("Displaying image: " + fileName);
    }
}
interface Image
{
    void display();
}