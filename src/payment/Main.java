package payment;

public class Main {

    public static void main(String[] args) {

        // Tạo đơn hàng
        Order order1 = new Order(
                "ORD001", "Nguyen Van A", 500000
        );

        Order order2 = new Order(
                "ORD002", "Tran Thi B", 1200000
        );

        Order order3 = new Order(
                "ORD003", "Le Van C", 850000
        );

        // Trường hợp 1: Thanh toán tiền mặt
        System.out.println("\n>>> CASE 1: CASH PAYMENT");

        PaymentProcessor cash = new CashPayment();
        cash.processPayment(order1);

        // Trường hợp 2: Thanh toán thẻ ngân hàng
        System.out.println("\n>>> CASE 2: CREDIT CARD PAYMENT");

        PaymentProcessor card =
                new CreditCardPayment("1234567890123456");

        card.processPayment(order2);

        // Trường hợp 3: Thanh toán ví điện tử
        System.out.println("\n>>> CASE 3: E-WALLET PAYMENT");

        PaymentProcessor wallet =
                new EWalletPayment("WALLET001");

        wallet.processPayment(order3);

        // Trường hợp 4: Thẻ ngân hàng không hợp lệ
        System.out.println("\n>>> CASE 4: INVALID CARD");

        PaymentProcessor invalidCard =
                new CreditCardPayment("12345");

        invalidCard.processPayment(order2);
    }
}