package ExceutorFramework;

import java.util.concurrent.*;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(() -> System.out.println("Task Scheduled after 5 second delay !"), 5, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> System.out.println("Task1 Scheduled after every 5 second delay !"), 5, 2, TimeUnit.SECONDS);

        scheduler.scheduleWithFixedDelay(() -> System.out.println("Task2 Scheduled after every 5 second delay !"), 5, 2, TimeUnit.SECONDS);

        scheduler.schedule(() -> {
            System.out.println("intializing shutdown....");
            scheduler.shutdown();
        }, 20, TimeUnit.SECONDS);
//        scheduler.shutdown();
    }
}
