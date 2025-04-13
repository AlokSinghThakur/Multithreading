package ExceutorFramework;

import java.util.concurrent.*;

public class ExecutorNew {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Callable<String> callable = ()->"Hello";
//        Future<?> future = executorService.submit(callable);
//        System.out.println(future.get());
//        if(future.isDone()){
//            System.out.println("Task Done");
//        }

        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello");
            return 42;
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception Occured "+ e);
        }
        //cancelled
        future.cancel(false);
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());

//        Integer i = null;
//        try {
//            i = future.get(1, TimeUnit.SECONDS);
//            System.out.println(future.isDone());
//            System.out.println(i);
//        } catch (TimeoutException |InterruptedException | ExecutionException e) {
//            System.out.println("Exception occureed: " + e);
//        }
        executorService.shutdown();
    }
}
