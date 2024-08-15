package basicMultithreading;

public class RunnableThreadExample{
    public static void main(String[] args){
            Thread t1 = new Thread(new ThreadOne());
            Thread t2 = new Thread(new ThreadTwo());
            Thread t3 = new Thread(new Runnable(){
                @Override
                public void run(){
                    for(int i = 0; i < 9; i++){
                        System.out.println("Thread3 " + i);
                    }
                }
            });

        Thread t4 = new Thread(() -> {
                for(int i = 0; i < 10; i++){
                    System.out.println("Thread3 " + i);
            }
        });
            t1.start();
            t2.start();
            t3.start();
            t4.start();
    }
}


class ThreadOne implements Runnable{
    @Override
    public void run() {
        for(int i =0 ; i < 8; i++){
            System.out.println("Thread1 " + i);
        }
    }
}

class ThreadTwo implements Runnable{
    @Override
    public void run() {
        for(int i =0 ; i < 7; i++){
            System.out.println("Thread2 " + i);
        }
    }
}