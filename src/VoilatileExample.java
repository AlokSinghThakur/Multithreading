class SharedObject {
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("Writer Thread made the flag true;");
        flag = true;
    }

    public void printIfFlag() {
        while (!flag) {

        }
        System.out.println("Flag is true");
    }
}

public class VoilatileExample {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedObject.setFlagTrue();
        });
        Thread readerThread = new Thread(() -> sharedObject.printIfFlag());
        writerThread.start();
        readerThread.start();
    }
}
