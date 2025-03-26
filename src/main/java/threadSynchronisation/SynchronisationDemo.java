package threadSynchronisation;

public class SynchronisationDemo {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException{
        Thread one = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                //Race Condition
                //  counter++;
                increment();
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i < 200000; i++) {
                //Race Condition
                //  counter++;

                increment();
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
        System.out.println("Count: " + counter);
    }

    private synchronized static void increment(){
        //Critical Section
        counter++;
    }
}