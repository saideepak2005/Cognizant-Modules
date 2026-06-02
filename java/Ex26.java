
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
