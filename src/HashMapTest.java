import java.math.BigDecimal;

public class HashMapTest {

	/**
	 * 根据已知数量出计算hashmap初始化容量大小
	 * @param a
	 * @return
	 */
	public static int getNum(int a){
		int n = a -1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		int result = n+1;
		BigDecimal data = new BigDecimal(a).divide(new BigDecimal("0.75"),0,BigDecimal.ROUND_HALF_UP);
		int flag = data.intValue();
		if(flag>result){
			return result<<1;
		}else{
			return result;
		}
	}

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n=(n < 0) ? 1:n+1;
        System.out.println(n);
        return n;
    }
	
	public static void main(String args[]){

        tableSizeFor(100);
		System.out.println(getNum(96));//128 -128
		System.out.println(getNum(100));//134 -256
	}
	
}
