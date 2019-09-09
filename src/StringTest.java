import java.util.HashMap;
import java.util.Map;

public class StringTest {

	public static void main(String[] args) {
		String s = new String("1")+new String("1");
//		s.intern();
		String s1 = "11";
		Map<String, String> map = new HashMap<>();
		System.out.println(s==s1);
	}
}
