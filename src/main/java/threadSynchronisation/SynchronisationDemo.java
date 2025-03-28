package threadSynchronisation;

public class SynchronisationDemo {

    private static int counter0 = 0;
    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) throws InterruptedException{
        Thread one = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                //Race Condition
                increment();
                //No Race Condition
                increment1();
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                //Race Condition
                increment();
                //No Race Condition
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
        System.out.println("Count0: " + counter0 );
        System.out.println("Count1: " + counter1 );
        System.out.println("Count2: " + counter2 );
    }
    //Problem with using synchronized at the method level...
    //It applies lock to entire method body. Blocking other threads from entering the method itself.
    //critical section could be a couple of lines of code, but if there are other non-critical section then other threads cannot use that part of the method.
    private static void increment(){
        //Critical Section
        counter0++;
    }
    private synchronized static void increment1(){
        //Critical Section
        counter1++;
    }
    private synchronized static void increment2(){
        //Critical Section
        counter2++;
    }
}
//Objects in Java, are associated with a monitor log which is a mutual exclusion mechanism