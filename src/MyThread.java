import java.util.Objects;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+ " is running");
            Thread.yield();
        }
    }


    public static void main(String[] arg) throws InterruptedException {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }
}

//  to run on single core process
// start /affinity 1 java MyThread.java
