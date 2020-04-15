
import java.util.Scanner;
import java.util.Random;

public class HomeWork {

	/**
	 * 输出一个整数的每一位
	 * @param args [description]
	 */

	 public static void outNum(int n) {
        if (n > 9) {
            outNum(n/10);
        }
        System.out.print(n%10 + " ");
    }

    public static void main14(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        outNum(n);
    }

	/**
	 * 输出乘法口诀表
	 * @param args [description]
	 */

	public static void main13(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i = 1; i <= n; i++) {
			for (int j = 1; j <= i;j ++) {
				System.out.printf("%d*%d=%-2d ",i,j,i*j);
			}
			System.out.println();
		}
	}

	/**
	 * 模拟登陆
	 * @param args [description]
	 */

	public static void main12(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int count = 3;
		while (count != 0) {
			System.out.println("请输入你的密码：");
			String password = scan.nextLine();
			if (password.equals("123456")) {
				System.out.println("登陆成功");
				break;
			}else {
				count--;
				System.out.println("你还有" + count + "次机会");
			}
		}
	}

	/**
	 * 获取一个数二进制序列中所有的偶数位和奇数位
	 * 分别输出二进制序列
	 * @param args [description]
	 */

	public  static void num(int n) {
        for (int i = 31; i >= 1; i -= 2) {
            System.out.print(((n >> i) & 1) + " ");
        }
        System.out.println();
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print(((n >> i) & 1) + " ");
        }
    }

    public static void main11(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n =scanner.nextInt();
    num(n);
    }



	/**
	 * 一个整数，在内存当中存储时，二进制1的个数
	 * @param args [description]
	 */
	
	public static int count1(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count ++;
        }
        return count;
    }

    public static void main10(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(count1(n));
    }

    /*public static int count(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if(((n>>i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(count(n));
    }*/

	/**
	 * 最大公约数
	 * @param args [description]
	 */

	public static void main9(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();
		int t = 1;
		while(t != 0) {
			t = i%j;
			i = j;
			j = t;
		}
		System.out.print(i);
	}

	/**
	 * 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
	 * @param args [description]
	 */

	public static void main8(String[] args) {
		double sum = 0;
		int j = 1;
		for (int i = 1; i <= 100; i++) {
			sum += (1.0 / i) * j;
			j = -j;
		}
		System.out.print(sum);
	}

	/**
	 * 求出0～999之间的所有“水仙花数”
	 * @param args [description]
	 */

	public static void main7(String[] args) {

		for (int n = 0; n < 999; n++) {
			int i = n;
			int sum = 0;
			while(i != 0) {
				sum += Math.pow(i%10,3);
				i = i/10;
			}
			if (sum == n) {
				System.out.print(n + " ");
			}
		}
	}

	/**
	 * 猜数字游戏
	 * @param args [description]
	 */

	public static void main6(String[] args) {
		
		Random random = new Random();
		int randNum = random.nextInt(100);
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("请输出你猜的数：");
			int i = scan.nextInt();
			if (i < randNum) {
				System.out.println("猜小了");
			}else if (i > randNum) {
				System.out.println("猜大了");
			}else {
				System.out.println("恭喜你猜对了");
				break;
			}
		}

	}

	/**
	 * 根据输入的年龄, 来打印出当前年龄的人
	 * 少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
	 * @param args [description]
	 */

	public static void main5(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()) {
			int age = scan.nextInt();
			if (age <= 18) {
				System.out.println("少年");
			}else if (age >= 19 && age <= 28) {
				System.out.println("青年");
			}else if (age >= 29 && age <= 55) {
				System.out.println("中年");
			}else {
				System.out.println("老年");
			}
		}
	}

	/**
	 * 给定一个数字，判定一个数字是否是素数
	 * @param args [description]
	 */

	public static void main4(String[] args) {

		Scanner scan = new Scanner(System.in);
		while(scan.hasNextInt()) {
			int i = scan.nextInt();
			int j = 2;
			for (; j <= (int)Math.sqrt(i); j++) {
				if (i%j == 0) {
					System.out.println(i + "不是素数");
					break;
				}
			}
			if (j > (int)Math.sqrt(i)) {
				System.out.println(i + "是素数");
			}
		}
		
	}

	/**
	 * 打印 1 - 100 之间所有的素数
	 * @param args [description]
	 */

	public static void main3(String[] args) {
		
		for (int i = 2; i <= 100; i++) {
			int j = 2;
			for (; j <= (int)Math.sqrt(i); j++) {
				if (i%j == 0) {
					break;
				}
			}
			if (j > (int)Math.sqrt(i)) {
				System.out.print(i + " ");
			}
		}
	}

	/**
	 * 输出 1000 - 2000 之间所有的闰年
	 * @param args [description]
	 */

	public static void main2(String[] args) {
		
		for (int year = 1000; year <= 2000; year++) {
			if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
				System.out.print(year + " ");
			}
		}
	}

	/**
	 * 数字9 出现的次数
	 * @param args [description]
	 */
	
	public static void main1(String[] args) {
		
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i%10 == 9) {
				count++;
			}else if (i/10 == 9) {
				count++;
			}
			
		}
		System.out.println(count);
	}

}