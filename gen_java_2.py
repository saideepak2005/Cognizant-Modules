import os

folder = r"c:\Users\91996\Desktop\cog\java"
os.makedirs(folder, exist_ok=True)

files = {}

files["InvalidAgeException.java"] = """
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) { super(msg); }
}
"""

files["Ex21.java"] = """
import java.util.Scanner;
public class Ex21 {
    public static void checkAge(int age) throws InvalidAgeException {
        if(age < 18) throw new InvalidAgeException("Age less than 18 not allowed.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        if(sc.hasNextInt()) {
            try {
                checkAge(sc.nextInt());
                System.out.println("Access granted.");
            } catch (InvalidAgeException e) {
                System.out.println("Caught Exception: " + e.getMessage());
            }
        }
    }
}
"""

files["Ex22.java"] = """
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Ex22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to write to file: ");
        if(sc.hasNextLine()) {
            String text = sc.nextLine();
            try (FileWriter fw = new FileWriter("output.txt")) {
                fw.write(text);
                System.out.println("Data written to output.txt successfully.");
            } catch (IOException e) { e.printStackTrace(); }
        }
    }
}
"""

files["Ex23.java"] = """
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Ex23 {
    public static void main(String[] args) {
        try (Scanner fileSc = new Scanner(new File("output.txt"))) {
            System.out.println("Reading from output.txt:");
            while(fileSc.hasNextLine()) {
                System.out.println(fileSc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("output.txt not found.");
        }
    }
}
"""

files["Ex24.java"] = """
import java.util.ArrayList;
import java.util.Scanner;
public class Ex24 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter student name (or type 'exit'): ");
            String name = sc.nextLine();
            if(name.equalsIgnoreCase("exit")) break;
            list.add(name);
        }
        System.out.println("All students:");
        for(String n : list) System.out.println(n);
    }
}
"""

files["Ex25.java"] = """
import java.util.HashMap;
import java.util.Scanner;
public class Ex25 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter ID (or -1 to stop): ");
            int id = sc.nextInt();
            if(id == -1) break;
            System.out.print("Enter Name: ");
            String name = sc.next();
            map.put(id, name);
        }
        System.out.print("Enter ID to retrieve: ");
        int query = sc.nextInt();
        System.out.println("Name: " + map.getOrDefault(query, "Not Found"));
    }
}
"""

files["Ex26.java"] = """
class MyThread extends Thread {
    private String msg;
    public MyThread(String msg) { this.msg = msg; }
    public void run() {
        for(int i=0; i<3; i++) System.out.println(msg);
    }
}
public class Ex26 {
    public static void main(String[] args) {
        new MyThread("Thread A").start();
        new MyThread("Thread B").start();
    }
}
"""

files["Ex27.java"] = """
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class Ex27 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Banana", "Apple", "Cherry");
        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println("Sorted: " + list);
    }
}
"""

files["Ex28.java"] = """
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Ex28 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Evens: " + evens);
    }
}
"""

files["Ex29.java"] = """
import java.util.List;
record Person(String name, int age) {}
public class Ex29 {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Alice", 20), new Person("Bob", 15), new Person("Charlie", 25));
        people.forEach(System.out::println);
        System.out.println("Adults:");
        people.stream().filter(p -> p.age() >= 18).forEach(System.out::println);
    }
}
"""

files["Ex30.java"] = """
public class Ex30 {
    public static void checkType(Object obj) {
        switch(obj) {
            case Integer i -> System.out.println("It's an Integer: " + i);
            case String s -> System.out.println("It's a String: " + s);
            case Double d -> System.out.println("It's a Double: " + d);
            default -> System.out.println("Unknown type");
        }
    }
    public static void main(String[] args) {
        checkType(10);
        checkType("Hello");
        checkType(10.5);
    }
}
"""

files["Ex31.java"] = """
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Ex31 {
    public static void main(String[] args) {
        try {
            // Assume sqlite for simplicity to avoid local mysql setup issues
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT)");
            stmt.execute("INSERT INTO students (name) VALUES ('Test Student')");
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
"""

files["Ex32.java"] = """
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Ex32 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT)");
            
            PreparedStatement insert = conn.prepareStatement("INSERT INTO students (name) VALUES (?)");
            insert.setString(1, "Alice");
            insert.executeUpdate();
            
            PreparedStatement update = conn.prepareStatement("UPDATE students SET name = ? WHERE id = ?");
            update.setString(1, "Alice Updated");
            update.setInt(2, 1);
            update.executeUpdate();
            System.out.println("Insert and Update successful.");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
"""

files["Ex33.java"] = """
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class Ex33 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bank.db")) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance REAL)");
            stmt.execute("INSERT OR IGNORE INTO accounts (id, balance) VALUES (1, 1000), (2, 500)");
            
            try (PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - 100 WHERE id = 1");
                 PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + 100 WHERE id = 2")) {
                debit.executeUpdate();
                credit.executeUpdate();
                conn.commit();
                System.out.println("Transfer successful, transaction committed.");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Transfer failed, transaction rolled back.");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
"""

files["Ex35Server.java"] = """
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
public class Ex35Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Server started on port 8888");
        Socket client = server.accept();
        System.out.println("Client connected");
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();
        out.write("Hello from server\n".getBytes());
        server.close();
    }
}
"""

files["Ex35Client.java"] = """
import java.net.Socket;
import java.io.InputStream;
import java.util.Scanner;
public class Ex35Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        Scanner sc = new Scanner(socket.getInputStream());
        System.out.println("Server says: " + sc.nextLine());
        socket.close();
    }
}
"""

files["Ex36.java"] = """
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Ex36 {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("https://api.github.com")).build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + res.statusCode());
        System.out.println("Body: " + res.body().substring(0, 100) + "...");
    }
}
"""

files["Ex37.java"] = """
// Compile with javac Ex37.java, then run javap -c Ex37
public class Ex37 {
    public void myMethod() {
        int a = 10;
        int b = 20;
        int c = a + b;
    }
}
"""

files["Ex38.java"] = """
// Compile this file and use JD-GUI or CFR on Ex38.class to see the decompiled source
public class Ex38 {
    public static void main(String[] args) {
        System.out.println("Decompile me!");
    }
}
"""

files["Ex39.java"] = """
import java.lang.reflect.Method;
public class Ex39 {
    public void sayHello(String name) { System.out.println("Hello, " + name); }
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Ex39");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        Method method = clazz.getDeclaredMethod("sayHello", String.class);
        System.out.println("Invoking: " + method.getName());
        method.invoke(obj, "Reflection API");
    }
}
"""

files["Ex40.java"] = """
public class Ex40 {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<100000; i++) {
            Thread.startVirtualThread(() -> {
                // System.out.println("Virtual thread running");
                // Commented to avoid flooding output
            });
        }
        System.out.println("100,000 Virtual threads started.");
        Thread.sleep(1000); // give them time to run
    }
}
"""

files["Ex41.java"] = """
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
public class Ex41 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () -> {
            System.out.println("Task executing...");
            return 42;
        };
        Future<Integer> future = exec.submit(task);
        System.out.println("Result: " + future.get());
        exec.shutdown();
    }
}
"""

# Modules for Ex34
module_dir = os.path.join(folder, "Ex34_Modules")
os.makedirs(os.path.join(module_dir, "com.utils"), exist_ok=True)
os.makedirs(os.path.join(module_dir, "com.greetings"), exist_ok=True)

with open(os.path.join(module_dir, "com.utils", "module-info.java"), 'w') as f:
    f.write("module com.utils {\n    exports com.utils;\n}\n")
    
with open(os.path.join(module_dir, "com.utils", "UtilClass.java"), 'w') as f:
    f.write("package com.utils;\npublic class UtilClass {\n    public static String getGreeting() { return \"Hello from Module\"; }\n}\n")

with open(os.path.join(module_dir, "com.greetings", "module-info.java"), 'w') as f:
    f.write("module com.greetings {\n    requires com.utils;\n}\n")
    
with open(os.path.join(module_dir, "com.greetings", "MainClass.java"), 'w') as f:
    f.write("package com.greetings;\nimport com.utils.UtilClass;\npublic class MainClass {\n    public static void main(String[] args) {\n        System.out.println(UtilClass.getGreeting());\n    }\n}\n")


for k, v in files.items():
    with open(os.path.join(folder, k), 'w') as f:
        f.write(v)
