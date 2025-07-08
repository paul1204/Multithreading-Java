package threadSynchronisation;

public class WaitAndNotify {
    private static final Object LOCK = new Object();

    public static void main(String[] args){

        Thread one = new Thread(()->{

            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread two = new Thread(()->{
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();

    }

    private static void one() throws InterruptedException{
        synchronized (LOCK){
            System.out.println("Hello from method 1");
            LOCK.wait();
            //wait is for inner thread communication
            System.out.println("Hello again in method 1");
        }
    }

    private static void two() throws InterruptedException{
        synchronized (LOCK){
            System.out.println("Hello from method 2");
            LOCK.notify();
            System.out.println("Hello again in method 2... even after notify");
        }
    }
}