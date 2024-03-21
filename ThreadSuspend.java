class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
    boolean suspended = false;
    boolean stopped = false;

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread: " + getName() + ", Count: " + i);
                Thread.sleep(1000); // Simulate some work
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                    if (stopped) {
                        break;
                    }
                }
            }
            System.out.println("Thread: " + getName() + " exiting.");
        } catch (InterruptedException e) {
            System.out.println("Thread: " + getName() + " interrupted.");
        }
    }
    synchronized void suspendThread() {
        suspended = true;
    }
    synchronized void resumeThread() {
        suspended = false;
        notify();
    }
    synchronized void stopThread() {
        stopped = true;
        suspended = false;
        notify();
    }
}
public class ThreadSuspend {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");
        t1.start();
        t2.start();
        Thread.sleep(2000); // Let threads run for a while
        // Suspend Thread1
        t1.suspendThread();
        System.out.println("Thread 1 suspended");
        Thread.sleep(2000); // Let it be suspended for a while
        // Resume Thread1
        t1.resumeThread();
        System.out.println("Thread 1 resumed");
        Thread.sleep(2000); // Let threads run for a while
        // Stop Thread1
        t1.stopThread();
        System.out.println("Thread 1 stopped");
        // Stop Thread2
        t2.stopThread();
        System.out.println("Thread 2 stopped");
    }
}
