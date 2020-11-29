public class OlderTicket implements BuyTicket{
	private final double DISCOUNT = 0.5;
	public double buy(double price) {
		System.out.println("老年票");
		return price * DISCOUNT;
	}
}
