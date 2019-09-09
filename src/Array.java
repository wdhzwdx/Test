import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Array {

	public void test1() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		List<Integer> list1 = new ArrayList<>();
		for (Integer item : list) {
			if (item > 2) {
				list1.add(item);
			}
		}
	}

	public void test2() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			if (iter.next() <= 2) {
				iter.remove();
			}
		}
	}
	
	public static void test3() {
		//假定有2K+1个数，其中有2k个相同，需要找出不相同的那个数
		int[] array = {3,4,4,3,2,5,6,5,6,5,5,7,7};
		int v = 0;
		for (int i = 0;i < array.length;i++) {
			v ^= array[i];
		}
		System.out.println("只出现一次的数是:" + v);
	}
	
	public static void test4() {
		List<String> aList = new ArrayList<>();
		aList.add("1");
		aList.add("a");
		Stream<String> stream=aList.stream().filter((e) -> {
            System.out.println("Stream API的中间操作");
            return "a".equals(e);
        });
		
		
		
		Optional<String> aString = stream.findFirst();
		System.out.println(aString.get());
		for(String aString2 : aList){
			System.out.println(aString2);
		}
	}
	
	public static void test5() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, year+1);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        
        Date currYearLast = calendar.getTime();
		SimpleDateFormat time=new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(time.format(currYearLast));
		System.out.println( calendar.get(Calendar.YEAR));
	}
	
	public static void test6() {
		String aS = "01210";
		String bvString = "ws";
		for(String item : bvString.split("")){
			aS = aS.replaceFirst("0", item);
		}
		
		System.out.println(aS);
		Pattern pattern = Pattern.compile("(?<=\\{)(.+?)(?=\\})");
		Matcher matcher = pattern.matcher("{A2!n#3}-{A1!2#3}");
		while(matcher.find()){
			System.out.println(matcher.group());
		}
	}
	
	public static void test7() {
		BigDecimal tBigDecimal = new BigDecimal("0.110");
		BigDecimal tBigDecima2 = new BigDecimal("0.11");
		System.out.println(tBigDecimal.compareTo(tBigDecima2)==0);
		String aString = "1<br\\>2";
		System.out.println(aString.replace("<br\\>",System.lineSeparator() ));
		int a = 0;
		for(int i =0;i<3;i++){
			System.out.println(a++);
		}
		Byte aByte = null;
		aByte =Byte.valueOf("3");
		aByte =2;
		System.out.println(aByte);
		
		System.out.println(new BigDecimal("-0.0464"));
	}
	
	public static void test8() {
		List<String> list = new ArrayList<>();
		list.add("0");
		list.add("1");
		list.add("0");
		list.add("1");
		list.add(null);
		Collections.sort(list,new Comparator<Object>() {
			@Override
			public int compare(Object obj1,Object obj2){
				if(obj1==null||"".equals(obj1)){
				return 1;
				}
				if(obj2==null||"".equals(obj2)){
				return 1;
				}
				return new Double((String)obj1).compareTo(new Double((String) obj2));
			}
		});
		for(String item : list){
			System.out.println(item);
		}
	}
	
	public static void test10() {
		Pattern pattern = Pattern.compile("(.*)现金的期初余额");
		Matcher matcher = pattern.matcher("   减：现金的期初余额");
		while(matcher.find()){
			System.out.println(matcher.group());
		}
	}
	
	/**
	 * List -> Map
	 * 需要注意的是：
	 * toMap 如果集合对象有重复的key，会报错Duplicate key ....
	 *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
	 */
	public static void listToMap() {
		List<AObject> aList = new ArrayList<>();
		AObject aObject = new AObject();
		aObject.setA("a");
		aObject.setB("B");
		AObject aObject1 = new AObject();
		aObject1.setA("a1");
		aObject1.setB("B1");
		aList.add(aObject);
		aList.add(aObject1);
		
		Map<String, AObject> map =  aList.stream().
				collect(Collectors.toMap(AObject::getA, AObject->AObject,(k1,k2)->k1));
		
		Map<String, AObject> map1 = aList.stream().
				collect(Collectors.toMap(AObject::getA, Function.identity(),(k1,k2)->k1));
	
		
	}
	
	public static void getNumber(String str){
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
		Matcher matcher = pattern.matcher(str);
		String result = "";
		while (matcher.find()) {
			String s = matcher.group();
			result += s;
		}
		System.out.println(result);
	}
	
	
	public static void getDate() {
		Date sDate = null;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date eDate = calendar.getTime();
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		//日期不为1号时，月开始时间都是变为1号，年月不变
		if(date!=1){
			calendar.set(Calendar.DATE, 1);
		}else if(month==0){
			//月份为1月时，即年初1月份，开始时间需转为上年12月份
			int year = calendar.get(Calendar.YEAR);
			calendar.set(Calendar.YEAR,year-1);
			calendar.set(Calendar.MONTH,11);
		}else{
			//月份不为1月时，只需月份减一
			calendar.set(Calendar.MONTH,month-1);
		}
		sDate = calendar.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
		System.out.println(simpleDateFormat.format(sDate));
		System.out.println(simpleDateFormat.format(eDate));
	}
	
	@SuppressWarnings("deprecation")
	public static Date getLastDayOfMonth(Date sDate) {
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(sDate);
		int lastDay = cDay.getActualMaximum(Calendar.DAY_OF_MONTH);
		cDay.set(Calendar.DAY_OF_MONTH, lastDay);
		Date lastDate = cDay.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(simpleDateFormat.format(lastDate));
		return lastDate;
	}
	
	/**
	 * 功能：获取当季度第一天  @return      * @return String    
	 */
	public static Date getCurrQuarterFirstDay(Date sDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cDay = Calendar.getInstance();
		cDay.setTime(sDate);
		System.out.println(cDay.get(Calendar.DAY_OF_MONTH));
		int curMonth = cDay.get(Calendar.MONTH);
		if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH) {
			cDay.set(Calendar.MONTH, Calendar.JANUARY);
		}
		if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE) {
			cDay.set(Calendar.MONTH, Calendar.APRIL);
		}
		if (curMonth >= Calendar.JULY && curMonth <= Calendar.SEPTEMBER) {
			cDay.set(Calendar.MONTH, Calendar.JULY);
		}
		if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {
			cDay.set(Calendar.MONTH, Calendar.OCTOBER);
		}
		cDay.set(Calendar.DAY_OF_MONTH, 1);
		String firstDay = format.format(cDay.getTime());
		System.out.println(firstDay);
		return cDay.getTime();
	}

	public static void fbTest(){
        int f1=1,f2=1,f;
        int M=30;
        System.out.println(2);
        System.out.println(2);
        for(int i=3;i<M;i++) {
            f=f2;
            f2=f1+f2;
            f1=f;
            System.out.println(f2);
        }
    }
	
	public static void main(String args[]) throws ParseException{

//        fbTest();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = simpleDateFormat.parse("2019-02-21");
//		getLastDayOfMonth(new Date());
//		getLastDayOfMonth(date);
//		getCurrQuarterFirstDay(new Date());
//		getCurrQuarterFirstDay(date);
//		getDate();
//		String aString="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
//				"<service>\r\n" + 
//				"	<head>\r\n" + 
//				"		<app_id>NNYDZ</app_id>\r\n" + 
//				"		<tran_id>SXSW.DZSWJ.DJ.CXDJXHBYNSRSBH</tran_id>\r\n" + 
//				"		<tran_version>V1.0</tran_version>\r\n" + 
//				"		<tran_seq>36dca744623945099963d0900909e04e</tran_seq>\r\n" + 
//				"		<tran_date>20190514</tran_date>\r\n" + 
//				"		<tran_time>160456470</tran_time>\r\n" + 
//				"		<sign>e5de0f1af95a44ad87b9f5a0e69b35e3</sign>\r\n" + 
//				"	</head>\r\n" + 
//				"<body>\r\n" + 
//				"<![CDATA[<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
//				"<taxML xsi:type=\"HXZGSB00040Request\" bbh=\"String\" xmlbh=\"String\" xmlmc=\"String\" xsi:schemaLocation=\"http://www.chinatax.gov.cn/dataspec/ TaxMLBw_HXZG_SB_00040_Request_V1.0.xsd\" xmlns=\"http://www.chinatax.gov.cn/dataspec/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
//				"	<sbNsrxxJhVO>\r\n" + 
//				"		<djxh>11140098000000055655</djxh>\r\n" + 
//				"		<skssqq>2019-01-01</skssqq>\r\n" + 
//				"		<skssqz>2014-03-31</skssqz>\r\n" + 
//				"		<sbsxDm1>11</sbsxDm1>\r\n" + 
//				"		<yzpzzlDm>BDA0610606</yzpzzlDm>\r\n" + 
//				"	</sbNsrxxJhVO>\r\n" + 
//				"</taxML>]]>\r\n" + 
//				"</body>\r\n" + 
//				"</service>";
//
//		System.out.println(aString.replaceAll("\\\\s*|\\t|\\r|\\n", ""));
//		
//		String res;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long lt = new Long("1558335639000") ;
//        Date date = new Date(lt);
//        res = simpleDateFormat.format(date);
//        System.out.println(res);
        
        

//		getNumber("123.  23123qdA_%$!@#^-><4");
//		getNumber("-123.23123");
//		getNumber("1110");
//		System.out.println(new StringBuilder("330000").replace(4, 6, "00"));
//		int s = (int) (Math.random() * 900000) + 100000;
//		System.out.println(s);
//		 Calendar cal = Calendar.getInstance();
//	        cal.add(Calendar.DAY_OF_YEAR, 1);
//	        cal.set(Calendar.HOUR_OF_DAY, 0);      
//	        cal.set(Calendar.SECOND, 0);
//	        cal.set(Calendar.MINUTE, 0);
//	        cal.set(Calendar.MILLISECOND, 0);
//	        Long time = (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
//        System.out.println(time);
//        System.out.println(time/3600);
//        
//		Pattern pattern = Pattern.compile("^科目代码$");
//		Matcher matcher = pattern.matcher("科目代码");
//		while(matcher.find()){
//			System.out.println(matcher.group());
//		}
//		String aString = ">";
//		int a = aString.indexOf(">=");
//		System.out.println(a);
//		String[] bString  = aString.split(">=");
//		System.out.println(bString);
//		String message = "总机构具有主体生产经营职能的部门分摊所得税额（15×全部分支机构分摊比例__%×总机构具有主体生产经营职能部门分摊比例__%)";
//		int index =message.lastIndexOf("__");
//		String value = message.substring(0,index)+"b"+message.substring(index+"__".length());
//		System.out.println(value);
//		listToMap();
//		System.exit(0);
    }
}
