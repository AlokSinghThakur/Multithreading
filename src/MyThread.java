import java.util.Objects;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        if (Objects.equals(Thread.currentThread().getName(), "High Priority")) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5000000; j++) {

                }
                System.out.println(Thread.currentThread().getName() + " -Priority " + Thread.currentThread().getPriority() + " -count " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        if (Objects.equals(Thread.currentThread().getName(), "Medium Priority")) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 1000000; j++) {

                }
                System.out.println(Thread.currentThread().getName() + " -Priority " + Thread.currentThread().getPriority() + " -count " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        if (Objects.equals(Thread.currentThread().getName(), "Low Priority")) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 500; j++) {

                }
                System.out.println(Thread.currentThread().getName() + " -Priority " + Thread.currentThread().getPriority() + " -count " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }

    }


    public static void main(String[] arg) throws InterruptedException {
        MyThread l = new MyThread("Low Priority");
        MyThread m = new MyThread("Medium Priority");
        MyThread h = new MyThread("High Priority");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);
        l.start();
        m.start();
        h.start();
    }
}
