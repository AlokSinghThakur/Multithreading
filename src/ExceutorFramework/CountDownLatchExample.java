package ExceutorFramework;

import java.util.concurrent.*;

public class CountDownLatchExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numberOfService = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfService);

//        Future<String> submit = executorService.submit(new ExceutorFramework.DependentService());
//        Future<String> submit1 = executorService.submit(new ExceutorFramework.DependentService());
//        Future<String> submit2 = executorService.submit(new ExceutorFramework.DependentService());
//
//        submit1.get();
//        submit2.get();
//        submit.get();
//
//        System.out.println("All Dependent Service Finished. Starting main Service...");

        //using CountDownLatch
        CountDownLatch latch = new CountDownLatch(numberOfService);

        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await();
        System.out.println("Main");
        executorService.shutdown();
    }
}

class DependentService implements Callable<String> {
    private final CountDownLatch latch;

    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " Service Started");
            Thread.sleep(2000);
        } finally {
            latch.countDown();
        }
        return "Ok";
    }
}
