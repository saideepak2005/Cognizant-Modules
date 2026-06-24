class BuilderPatternExample {
    public static void main(String[] args) 
    {
        Computer c = new Computer.Builder()
                .setcpu("Intel i7")
                .setram("16GB")
                .setstorage("1TB SSD")
                .build();
        c.display();
    }
}

class Computer
{
    private String cpu , ram , storage;
    Computer(Builder builder)
    {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }
    public void display()
    {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
    }
    
    static class Builder
    {
        private String cpu , ram , storage;
        Builder setcpu(String cpu)
        {
            this.cpu = cpu;
            return this;
        }
        Builder setram(String ram)
        {
            this.ram = ram;
            return this;
        }
        Builder setstorage(String storage)
        {
            this.storage = storage;
            return this;
        }
        Computer build()
        {
            return new Computer(this);
        }
    }
}