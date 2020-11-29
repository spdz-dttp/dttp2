public class Older implements Person {
	public void who() {
		Customer customer = new Customer();
		double orginalPrice = 60.0;
		BuyTicket buyTicket;
		buyTicket = new OlderTicket();
		customer.setPrice(orginalPrice);
		customer.setBuyTicket(buyTicket);
		System.out.printf("票价：%.1f%n",customer.getPrice());
	}
}
