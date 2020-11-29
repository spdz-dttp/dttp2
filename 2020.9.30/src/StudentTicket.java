public class StudentTicket implements BuyTicket{
		private final double DISCOUNT = 0.8;
		public double buy(double price) {
			System.out.println("学生票");
			return price * DISCOUNT;
		}
	}
