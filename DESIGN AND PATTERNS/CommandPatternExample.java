public class CommandPatternExample
{
    public static void main(String[] args)
    {
        Light light = new Light();

        Command onCommand =
                new LightOnCommand(light);

        Command offCommand =
                new LightOffCommand(light);

        RemoteControl remote =
                new RemoteControl();

        remote.setCommand(onCommand);
        remote.pressButton();

        remote.setCommand(offCommand);
        remote.pressButton();
    }
}
class RemoteControl
{
    private Command command;

    public void setCommand(Command command)
    {
        this.command = command;
    }

    public void pressButton()
    {
        command.execute();
    }
}
class LightOffCommand implements Command
{
    private Light light;

    public LightOffCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute()
    {
        light.off();
    }
}
class LightOnCommand implements Command
{
    private Light light;

    public LightOnCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute()
    {
        light.on();
    }
}
class Light
{
    public void on()
    {
        System.out.println("Light is ON");
    }

    public void off()
    {
        System.out.println("Light is OFF");
    }
}
interface Command
{
    void execute();
}