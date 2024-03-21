
class thread1 extends Thread{
    public void run(){
        for( int i=1; i<=5; i++){
            System.out.println("\t From First Thread : i=" +i);
        }System.out.println("Exit From Thread 1");
    }
}
class thread2 extends Thread{
    public void run(){
        for( int j=1; j<=5; j++){
            System.out.println("\t From Second Thread : j=" +j);
        }System.out.println("Exit From Thread 2");
    }
}
class thread3 extends Thread{
    public void run(){
        for( int k=1; k<=5; k++){
            System.out.println("\t From  Third Thread : k=" +k);
        }System.out.println("Exit From Thread 3");
    }
}
public class SKThreadRun {
    public static void main(String[] args) {
        new thread1().run();
        new thread2().run();
        new thread3().run();
    }
    
}