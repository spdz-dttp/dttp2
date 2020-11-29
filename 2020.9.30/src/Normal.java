public class Normal implements Person {
	public void who() {
		Customer customer = new Customer();
		double orginalPrice = 60.0;
		BuyTicket buyTicket;
		buyTicket = new NormalTicket();
		customer.setPrice(orginalPrice);
		customer.setBuyTicket(buyTicket);
		System.out.printf("票价：%.1f%n",customer.getPrice());
	}
}
