/**
 * 双重检测锁+volatile  实现单例线程安全
 */
public class Dcl {
    private volatile static J1 a;

    private Dcl(){}

    public static J1 getInstance(){
        if(a==null){       //a2
            synchronized (a){
               if(a==null){
                   /**
                    *  1、开启堆内存，2、堆保存到栈内存的引用中，3、创建对象
                    *  如果不加volatile，指令重排序时，  线程A到a1这， 线程B到a2，时，当指令2和3,重排序时，
                    *  线程B得到了对象不为空，但其实还未引用堆地址
                    *  volatile 可以做到有序性，防止指令重排序
                    */
                   a = new J1();        //a1

               }
            }
        }
        return a;
    }

}
