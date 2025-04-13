package ExceutorFramework;

import java.util.concurrent.*;

public class ExecutorNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = ()->"Hello";
        Future<?> future = executorService.submit(callable);
        System.out.println(future.get());
        if(future.isDone()){
            System.out.println("Task Done");
        }
        executorService.shutdown();
    }
}
