import java.util.Objects;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Hello world");
        }
    }


    public static void main(String[] arg) throws InterruptedException {
        MyThread t1 = new MyThread("t1");
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main Done");
    }
}

//  to run on single core process
// start /affinity 1 java MyThread.java
