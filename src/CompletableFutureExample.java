import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            //Daemon Thread
            try {
                System.out.println("Worker");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            //Daemon Thread
            try {
                System.out.println("Worker1");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "ok";
        });
        String s = null;
        CompletableFuture<Void> f = CompletableFuture.allOf(f1, f2);
        f.join();
        System.out.println("main");
//        try {
////            s = completableFuture.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(s);

        System.out.println("Main");

    }
}
