package threadSynchronisation;

public class LockWithCustomObjects {
    private static int counter1 = 0;
    private static int counter2 = 0;
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException{
        Thread one = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment1();
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                increment2();
            }
        });
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Count1: " + counter1 );
        System.out.println("Count2: " + counter2 );
    }

    //Better Practice.
    //Synchronization is at the block level, not method level
    private synchronized static void increment1(){
        synchronized(lock1){
        //Critical Section
        counter1++;
        }
    }
    private synchronized static void increment2(){
        synchronized(lock2){
            //Critical Section
            counter2++;
        }
    }
}
