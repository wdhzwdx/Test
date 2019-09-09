
public class Test2 {

	class A{
	    B b;
    }

    class B{
	    A a;
    }

    A creatA(){
	    return new A();
    }

    B creatB(){
        return new B();
    }

	public static void main(String[] args) {
        Test2 test = new Test2();
        A a = test.creatA();
        B b = test.creatB();
        a.b = b;
        b.a = a;

        a=null;
        b=null;
        System.out.println("完成");
	}

}
