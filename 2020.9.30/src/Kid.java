public class Kid implements Person {
	public void who() {
		Customer customer = new Customer();
		double orginalPrice = 60.0;
		BuyTicket buyTicket;
		buyTicket = new KidTicket();
		customer.setPrice(orginalPrice);
		customer.setBuyTicket(buyTicket);
		System.out.printf("票价：%.1f%n",customer.getPrice());
	}
}
