public class Student implements Person {
	public void who() {
		Customer customer = new Customer();
		double orginalPrice = 60.0;
		BuyTicket buyTicket;
		buyTicket = new StudentTicket();
		customer.setPrice(orginalPrice);
		customer.setBuyTicket(buyTicket);
		System.out.printf("票价：%.1f%n",customer.getPrice());//duoble类型的输出用  %.nf  输出，n 是小数点后位数
	}
}
