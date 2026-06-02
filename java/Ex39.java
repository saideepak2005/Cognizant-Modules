
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
