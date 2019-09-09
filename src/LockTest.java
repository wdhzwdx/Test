import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable{
    private  final ReentrantLock lock  = new ReentrantLock();
    private int num =0;


    @Override
    public void run() {
        lock.lock();
        try {
//            try {
//                Thread.sleep(3000);
//            } catch (Exception e) {
//
//            }
            System.out.println(Thread.currentThread().getName()+":"+ num++);
//            for(;;){
//                System.out.println(Thread.currentThread().getName());
//            }
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        LockTest t = new LockTest();
        for(int i=0;i<20;i++){
            new Thread(t).start();
        }
    }

}
