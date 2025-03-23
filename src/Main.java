public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        World world = new World();
        world.start();
        for (; ; ) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}