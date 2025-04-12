import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + "attempting to withdraw " + amount);

        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {

                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "proceeding  withdraw " + amount);
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + "completed withdrawal final amount =" + amount);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " has insufficient balance");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not aquire the lock will try again later");

            }

        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
