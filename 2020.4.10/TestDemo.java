import java.util.Scanner;

public class TestDemo {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);

		/*// n的阶乘
		while(scan.hasNextInt()) {

			int num = scan.nextInt();
			int i = 1;
			int ret = 1;
			while(i <= num) {
				ret *= i;
				i++;
			}
			System.out.println(ret);
		}*/

		//  n的阶乘和
		while(scan.hasNextInt()) {

			int num = scan.nextInt();
			int i = 1;
			int ret = 1;
			int sum = 0;
			while(i <= num) {
				ret *= i;
				sum += ret;
				i++;
			}

			System.out.println(sum);
		}

	}

	/**
	 * 不能做switch参数的类型有哪些?
	 * long  float  double   boolean
	 * @param args [description]
	 */

	public static void main8(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(); 
		switch(a) {
			case 1:
				System.out.println("1");
				break;
			case 2:
				System.out.println("2");
				break;
			default:
				System.out.println("请输入正确的数字");
				break;
		}
	}

	public static void main7(String[] args) {
		
		int x = 10;
		int y = 10;
		if (x == 10) {
			if (y == 10){
				System.out.println("aaa");
			}
			else {
				System.out.println("bbb");
			}
		}
			
	}

	public static void main6(String[] args) {
		
		/*int a = 10;
		if(a==10) {
			System.out.println("hello");
		}*/

		Scanner scan = new Scanner(System.in);
		//退出循环：ctrl+c (直接中断程序)  
		//          ctrl+D (正常退出)
		while(scan.hasNextInt()) {

			int year = scan.nextInt();

			if(year%4==0 && year%100!=0 || year%400==0) {

				System.out.println(year + "是闰年");
			}
			
			else {
				System.out.println(year + "不是闰年");
			}
		}

	}

	public static void main5(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String str = scan.nextLine();
		System.out.println(str + "\n");
		String str1 = scan.next();//next遇到空格会结束掉
		System.out.println(str1);
	}

	public static void main4(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String str = scan.nextLine();
		System.out.println(str);
		int a = scan.nextInt();
		System.out.println(a);

		int a1 = scan.nextInt();
		System.out.println(a1);
		String str1 = scan.next();//next
		System.out.println(str1);


		
	}

	public static void main3(String[] args) {
		
		int i = 10;
		i = i++;
		System.out.println(i);//10

		int a = 10;
		int b = 20;
		System.out.println(a == b);
		System.out.println(a != b);
		System.out.println(a < b);
		System.out.println(a > b);
		System.out.println(a <= b);
		System.out.println(a >= b);

		//System.out.println(!a < b);//错误 !只能用于boolean
		boolean flg = true;
		System.out.println(!flg);
	}

	public static void main2(String[] args) {

		/*System.out.println(10%3);
		System.out.println(-10%3);
		System.out.println(10%-3);
		System.out.println(-10%-3);*/

		//System.out.println(5/0);//错误  算数异常
		
		int a = 10;
		int b = ++a;
		System.out.println(b);
		System.out.println(a);
		int c = a++;
		System.out.println(c);
		System.out.println(a);

	}

	public static void main1(String[] args) {

		System.out.println("hello");
		System.out.println(5/2);
		System.out.println(5.0/2);
		System.out.println((float)5/2);
		System.out.println((float)(5/2));

	}
}