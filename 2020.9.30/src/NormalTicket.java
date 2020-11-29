public class NormalTicket implements BuyTicket{
	private final double DISCOUNT = 1.0;
	public double buy(double price) {
		System.out.println("成人票");
		return price * DISCOUNT;
	}
}