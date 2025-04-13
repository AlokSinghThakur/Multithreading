package ExceutorFramework;

import java.util.concurrent.*;

public class FutureExecution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<?> future = executorService.submit(() -> System.out.println("Hello"));
//        future.get();
//
//        Future<String> submit = executorService.submit(() -> System.out.println("Hello123"), "success");
//        executorService.shutdown();
        Future<Integer> submit = executorService.submit(() -> 1 + 2);
        Integer i = submit.get();

        System.out.println("Sum is " + i);
        executorService.shutdown();
        Thread.sleep(1);
        System.out.println(executorService.isTerminated());


    }


}
