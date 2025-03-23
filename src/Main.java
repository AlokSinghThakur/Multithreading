public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        World world = new World();
        Thread t1 = new Thread(world);
        t1.start();
        for (; ; ) {
            System.out.println("hello");
        }
    }
}