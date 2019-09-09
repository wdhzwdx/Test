
public class J1 implements J2{
    @Override
	public String test(){
		return "1";
	}

	public static void main(String[] args) {
		J2 tJ1 = new J1();
		System.out.println(tJ1.test());
	}
}
