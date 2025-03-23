public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        World world = new World(); //New
        Thread t1 = new Thread(world);
        t1.start(); // Runnable
        for (; ; ) {
            System.out.println("hello");
        }
    }
}