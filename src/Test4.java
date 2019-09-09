public class Test4 {

    public static void getInstance(Test3 test){
        test.setT("2");
        test = null;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        test3.setT("1");
        Test4.getInstance(test3);
        test3.getString();
    }
}
