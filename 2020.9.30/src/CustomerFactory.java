public class CustomerFactory {
	public static void main(String[] args) {
		Customer customer = new Customer();
		double orginalPrice = 60.0;
		BuyTicket buyTicket;
		buyTicket = new StudentTicket();
		customer.setPrice(orginalPrice);
		customer.setBuyTicket(buyTicket);
		customer.getPrice();
		
	}
}
