class thread1 extends Thread{
    public void run(){
        for( int i=1; i<=5; i++){
            if(i==2)
            thread1.yield();
            System.out.println("\t From First Thread : i=" +i);
        }System.out.println("Exit From Thread 1");
    }
}
class thread2 extends Thread{
    @SuppressWarnings("removal")
    public void run(){
        for( int j=1; j<=5; j++){
            if(j==3){
                stop();
            } 
            System.out.println("\t From Second Thread : j=" +j);
        }System.out.println("Exit From Thread 2");
    }
}
class thread3 extends Thread{
    public void run(){
        for( int k=1; k<=5; k++){
            if(k==1)
            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("\t From  Third Thread : k=" +k);
        }System.out.println("Exit From Thread 3");
    }
}
public class SKThreadThreeMethod {
    public static void main(String[] args) {
        thread1 Thread_01 = new thread1();
        thread2 Thread_02 = new thread2();
        thread3 Thread_03 = new thread3();
        System.out.println("Execution Started");
        System.out.println("Start The First Thread");
        Thread_01.start();
        System.out.println("Start The Second Thread");
        Thread_02.start();
        System.out.println("Start The Third Thread");
        Thread_03.start();
    }
}
