public class KidTicket implements BuyTicket{
	private final double DISCOUNT = 0;
	public double buy(double price) {
		System.out.println("儿童票");
		return price * DISCOUNT;
	}
}