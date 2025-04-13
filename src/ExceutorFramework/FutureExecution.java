package ExceutorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureExecution {
    public static void main(String[] args) {


//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<?> future = executorService.submit(() -> System.out.println("Hello"));
//        future.get();
//
//        Future<String> submit = executorService.submit(() -> System.out.println("Hello123"), "success");
//        executorService.shutdown();


//        Future<Integer> submit = executorService.submit(() -> 1 + 2);
//        Integer i = submit.get();
//
//        System.out.println("Sum is " + i);
//        executorService.shutdown();
//        Thread.sleep(1);
//        System.out.println(executorService.isTerminated());

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> callable1 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 1");
            return 1;
        };

        Callable<Integer> callable2 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 2");
            return 2;
        };

        Callable<Integer> callable3 = () -> {
            Thread.sleep(1000);
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1, callable2, callable3);
//Invoke All
//        List<Future<Integer>> futures = null;
//        try {
//            futures = executorService.invokeAll(list,2, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        for(Future<Integer> f: futures){
//            try {
//                System.out.println(f.get());
//            } catch (CancellationException e) {
//            }catch (InterruptedException e) {
//            } catch (ExecutionException e) {
//            }
//        }
        executorService.shutdown();
        System.out.println("task  Done");
    }
}
