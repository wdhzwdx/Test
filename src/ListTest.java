import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {

    public static void arrayList(){
        //ArrayList  最好指定大小，防止扩容，默认是10
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<12;i++){
            list.add(i);
        }
        System.out.println(list.toString());
        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<13;i++){
            if(i!=1||i!=3){
                list1.add(i);

            }
        }
        list1.add(null);
        System.out.println(list1.toString());
//        list.retainAll(list1);//交集
        list.removeAll(list1);

        System.out.println(list.toString());
    }

    public static void linkedListTest(){
        LinkedList<String> list = new LinkedList<>();
        //调用addFirst->linkfirst
        list.push("1");
        //代用linklast ==addlast
        list.add("3");
        list.add(null);
        list.add(null);
//        list.remove();
        System.out.println(list.toString());
    }

    public static void copeyOnWriteArrayListTest(){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.addIfAbsent("1");
        list.addIfAbsent("1");
        list.add("1");
        list.add(null);
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        arrayList();
        linkedListTest();
        copeyOnWriteArrayListTest();
    }

}
