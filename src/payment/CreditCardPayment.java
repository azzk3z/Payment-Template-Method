package payment;

public class CreditCardPayment extends PaymentProcessor {

    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    protected boolean executePayment(Order order) {
        System.out.println("3. Processing CREDIT CARD payment...");

        if (cardNumber == null
                || !cardNumber.matches("\\d{16}")) {
            System.out.println("   Invalid card number!");
            return false;
        }

        System.out.println("   Verifying card information...");
        System.out.println("   Connecting to bank...");
        System.out.println("   Card payment approved.");

        return true;
    }
}	