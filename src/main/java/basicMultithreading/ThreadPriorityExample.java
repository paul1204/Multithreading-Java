package basicMultithreading;

public class ThreadPriorityExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
       // Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());

        System.out.println(Thread.currentThread().getName() + " hello from Main Thread!");

       // Thread.sleep(1000);

        Thread one = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread one: " + i + " Min Priority");
            }
        });
        one.setPriority(Thread.MIN_PRIORITY);

        Thread two = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread two: " + i + " Max Priority");
            }
        });
        two.setPriority(Thread.MAX_PRIORITY);

        one.start();
        two.start();

        //With Thread.sleep() we are assuring Thread one and two finish before main thread ends.
        //Without Thread.sleep() main thread will finish first before executing Thread one and two
        Thread.sleep(100);

        System.out.println("Main thread done.");
    }
}

