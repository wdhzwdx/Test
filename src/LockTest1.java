public class LockTest1 implements Runnable{
    private int num =0;

    @Override
    public void run() {
//            try {
//                Thread.sleep(3000);
//            } catch (Exception e) {
//
//            }
            System.out.println(Thread.currentThread().getName()+":"+ num++);

    }


    public static void main(String[] args) {
        LockTest1 t = new LockTest1();
        for(int i=0;i<20;i++){
            new Thread(t).start();
        }
    }

}
