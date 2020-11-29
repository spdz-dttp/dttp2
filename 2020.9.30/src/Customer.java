public class Customer {
	private double price;
	private BuyTicket buyTicket;
	
	public void setPrice(double price) {
		this.price = price;
	};
	
	public double getPrice() {
		return buyTicket.buy(this.price);
	}
	
	public void setBuyTicket(BuyTicket buyTicket) {
		this.buyTicket = buyTicket;
	}
}
