
class Car {
    String make, model;
    int year;
    public Car(String make, String model, int year) {
        this.make = make; this.model = model; this.year = year;
    }
    public void displayDetails() {
        System.out.println(year + " " + make + " " + model);
    }
}
public class Ex17 {
    public static void main(String[] args) {
        Car c = new Car("Toyota", "Camry", 2022);
        c.displayDetails();
    }
}
