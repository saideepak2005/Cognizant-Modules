import os

folder = r"c:\Users\91996\Desktop\cog\java"
os.makedirs(folder, exist_ok=True)

files = {}

files["Ex1.java"] = """
public class Ex1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
"""

files["Ex2.java"] = """
import java.util.Scanner;
public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        if (!sc.hasNextDouble()) return;
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);
        double res = 0;
        switch(op) {
            case '+': res = a + b; break;
            case '-': res = a - b; break;
            case '*': res = a * b; break;
            case '/': res = a / b; break;
            default: System.out.println("Invalid op"); return;
        }
        System.out.println("Result: " + res);
    }
}
"""

files["Ex3.java"] = """
import java.util.Scanner;
public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if(sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num % 2 == 0) System.out.println("Even");
            else System.out.println("Odd");
        }
    }
}
"""

files["Ex4.java"] = """
import java.util.Scanner;
public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        if (sc.hasNextInt()) {
            int year = sc.nextInt();
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            System.out.println(year + " is leap year: " + isLeap);
        }
    }
}
"""

files["Ex5.java"] = """
import java.util.Scanner;
public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            for(int i=1; i<=10; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }
        }
    }
}
"""

files["Ex6.java"] = """
public class Ex6 {
    public static void main(String[] args) {
        int i = 10;
        float f = 10.5f;
        double d = 20.99;
        char c = 'A';
        boolean b = true;
        System.out.println("int: " + i);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + b);
    }
}
"""

files["Ex7.java"] = """
public class Ex7 {
    public static void main(String[] args) {
        double d = 9.99;
        int i = (int) d;
        System.out.println("Double to int: " + i);
        
        int a = 100;
        double b = (double) a;
        System.out.println("Int to double: " + b);
    }
}
"""

files["Ex8.java"] = """
public class Ex8 {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result);
        System.out.println("Explanation: Multiplication has higher precedence than addition, so 5 * 2 is evaluated first (10), then 10 + 10 = 20.");
    }
}
"""

files["Ex9.java"] = """
import java.util.Scanner;
public class Ex9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks (0-100): ");
        if (sc.hasNextInt()) {
            int marks = sc.nextInt();
            if (marks >= 90) System.out.println("A");
            else if (marks >= 80) System.out.println("B");
            else if (marks >= 70) System.out.println("C");
            else if (marks >= 60) System.out.println("D");
            else System.out.println("F");
        }
    }
}
"""

files["Ex10.java"] = """
import java.util.Scanner;
import java.util.Random;
public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = new Random().nextInt(100) + 1;
        int guess = 0;
        while(guess != target) {
            System.out.print("Guess the number (1-100): ");
            if(!sc.hasNextInt()) break;
            guess = sc.nextInt();
            if(guess > target) System.out.println("Too high");
            else if(guess < target) System.out.println("Too low");
            else System.out.println("Correct!");
        }
    }
}
"""

files["Ex11.java"] = """
import java.util.Scanner;
public class Ex11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        if(sc.hasNextLong()) {
            long num = sc.nextLong();
            long fact = 1;
            for(long i = 1; i <= num; i++) {
                fact *= i;
            }
            System.out.println("Factorial: " + fact);
        }
    }
}
"""

files["Ex12.java"] = """
public class Ex12 {
    public static int add(int a, int b) { return a + b; }
    public static double add(double a, double b) { return a + b; }
    public static int add(int a, int b, int c) { return a + b + c; }
    
    public static void main(String[] args) {
        System.out.println("add(int, int): " + add(5, 10));
        System.out.println("add(double, double): " + add(5.5, 10.5));
        System.out.println("add(int, int, int): " + add(1, 2, 3));
    }
}
"""

files["Ex13.java"] = """
import java.util.Scanner;
public class Ex13 {
    public static int fibonacci(int n) {
        if(n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        if(sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println("Fibonacci(" + n + "): " + fibonacci(n));
        }
    }
}
"""

files["Ex14.java"] = """
import java.util.Scanner;
public class Ex14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        if(sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            System.out.println("Enter elements:");
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + (double)sum/n);
        }
    }
}
"""

files["Ex15.java"] = """
import java.util.Scanner;
public class Ex15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        if(sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println("Reversed: " + new StringBuilder(str).reverse().toString());
        }
    }
}
"""

files["Ex16.java"] = """
import java.util.Scanner;
public class Ex16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        if(sc.hasNextLine()) {
            String str = sc.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String rev = new StringBuilder(str).reverse().toString();
            System.out.println("Is Palindrome: " + str.equals(rev));
        }
    }
}
"""

files["Ex17.java"] = """
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
"""

files["Ex18.java"] = """
class Animal {
    public void makeSound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    @Override
    public void makeSound() { System.out.println("Bark"); }
}
public class Ex18 {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.makeSound();
        Dog d = new Dog();
        d.makeSound();
    }
}
"""

files["Ex19.java"] = """
interface Playable { void play(); }
class Guitar implements Playable {
    public void play() { System.out.println("Playing Guitar"); }
}
class Piano implements Playable {
    public void play() { System.out.println("Playing Piano"); }
}
public class Ex19 {
    public static void main(String[] args) {
        Playable g = new Guitar();
        g.play();
        Playable p = new Piano();
        p.play();
    }
}
"""

files["Ex20.java"] = """
import java.util.Scanner;
public class Ex20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Num 1: ");
            int a = sc.nextInt();
            System.out.print("Num 2: ");
            int b = sc.nextInt();
            System.out.println("Result: " + (a/b));
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
"""

for k, v in files.items():
    with open(os.path.join(folder, k), 'w') as f:
        f.write(v)

