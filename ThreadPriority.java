class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " is running with priority: " + getPriority() + ", Count: " + i);
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted.");
            }
        }
    }
}
public class ThreadPriority {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");
        MyThread t3 = new MyThread("Thread 3");
        t1.setPriority(Thread.MIN_PRIORITY); // Set lowest priority
        t2.setPriority(Thread.NORM_PRIORITY); // Set normal priority (default)
        t3.setPriority(Thread.MAX_PRIORITY); // Set highest priority
        t1.start();
        t2.start();
        t3.start();
    }
}

