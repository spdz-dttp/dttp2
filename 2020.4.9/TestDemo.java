


public class TestDemo {

	/**
	 * 隐式类型转换：
	 *    把 小类型 给 大类型
	 * 显式类型转换：
	 *    把大类型给小类型 需要  强制类型转换
	 * @param args [description]
	 */

	public static void main(String[] args) {
		
		int a = 10;
		long b = a;
		System.out.println(b);//隐式类型转换
		long c = 10L;
		int d = (int)c;//显式类型转换  强制类型转换
		System.out.println(d);

		// int n = 10;
		// boolean m = n; //错误 int  boolean 不能相互转换
	
		// int  转换  string
		//方法一
		int num = 10;
		String str1 = num + "";
		//方法二
		String str2 = String.valueOf(num);

		// string  转换  int
		String str3 = "100";
		int num1 = Integer.parseInt(str3);
		System.out.println(num1);
	}

	/**
	 * 常量只能被初始化一次  且使用时一定要初始化
	 * final 修饰的变量也是常量
	 * 常量名一般全是大写
	 * @param args [description]
	 */

	public static void main10(String[] args) {

		final int MAXNUM = 10;
		//MAXNUM = 999;//错误
		System.out.println(MAXNUM);
		
	}

	/**
	 * 字符串数据类型：
	 * String
	 * @param args [description]
	 */

	public static void main9(String[] args) {
		
		String str = "\"hello\"";
		System.out.println(str);

	}

	/**
	 * 布尔类型
	 * 1、在java中 布尔类型 没有明确的大小
	 * 2、在java中 布尔类型 只有两个取值  true 和 false
	 * 3、在Java中 没有 0是假 非0是真
	 *    真只有true 假只有false
	 *  4、Bollean
	 * @param args [description]
	 */

	public static void main8(String[] args) {
		
		boolean flg = false;
		System.out.println(flg);
		
	}

	/**
	 * 短整型：short   2个字节    -32768--32767
	 * @param args [description]
	 */

	public static void main7(String[] args) {
		
		short sh = 12;
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
	}

	/**
	 * 字节： byte   1个字节   -128--127
	 * 每一种数据类型 在给其赋值时 一定不能超过它的范围
	 *
	 * 小于4个字节的数据类型  运算时  会发生整型的提升
	 * @param args [description]
	 */

	public static void main6(String[] args) {

		byte b = 12;
		byte c = 21;
		System.out.println(b+" " + c);
		// byte n = b + c;//错误  整型提升
		// System.out.println(n);
		byte n = (byte)(b + c);
		System.out.println(n);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);

		// int d = Byte.MAX_VALUE + 1;
		// byte e = Byte.MAX_VALUE + 1;
		// System.out.println(d+" " + e);
		

		System.out.println(Byte.MAX_VALUE+1);//默认以整型打印


		//byte d = 130;//最大127，错误
		
		byte d = 127;
		System.out.println(d);	

		System.out.println(Integer.MAX_VALUE);

		int i = 2147483647;
		System.out.println(i);
		System.out.println(i + 1);

		// int j = 2147483648;//最大2147483647，错误
		// System.out.println(j);

	}

	/**
	 * 字符数据类型：
	 *    char    2个字节     0-65535
	 * Unicode-->他包含了很多，比如： 中文，变得更大了。
	 * Character
	 * @param args [description]
	 */

	public static void main5(String[] args) {
		
		char ch = 'a';
		System.out.println(ch);

		char ch2 = '高';
		System.out.println(ch2);

		char ch3 = 97;
		System.out.println(ch3);
	}

	/**
	 * 单精度 float
	 * 1、double 8个字节
	 * 2、float  4个字节
	 * @param args [description]
	 */

	public static void main4(String[] args) {

		float f = 12.3f;
		System.out.println(f);
	}

	/**
	 * 双精度 浮点型
	 * @param args [description]
	 */

	public static void main3(String[] args) {
		double d = 12.5;
		System.out.println(d);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);

		int a = 1;
		int b = 2;
		double c = 2.0;
		System.out.println(a / b);// 结果是0，a和b都是整型 
		System.out.println(a / c);

		double num = 1.1;
		double num1 = 12.5;

		System.out.println(num * num);
		System.out.printf("%.2f\n",num * num);
		System.out.println(num1 * num1);

	}

	/**
	 * String[] args 代表的是运行时命令行参数
	 * @param args [description]
	 */
	public static void main2(String[] args) {

		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i]);
			System.out.print(" ");
		}
		System.out.println("kaixin");
	}


	/**
	 * 讲解长整型
	 * @param args [description]
	 */
	public static void main1(String[] args) {
		
		long a = 10L;

		System.out.println("hello中国");

		System.out.println("a的值：" + a);// + 拼接
		System.out.println("最大值：" + Long.MAX_VALUE);
		System.out.println("最小值：" + Long.MIN_VALUE);

		int b = 10;
		int c = 20;
		System.out.println(b + c);
		//注意：任何类型的数据 和 字符串进行拼接 结果就是字符串
		System.out.println("hhh" + b + c);
		System.out.println("hhh" + (b + c));
	}
}
