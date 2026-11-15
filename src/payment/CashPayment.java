package payment;

public class CashPayment extends PaymentProcessor {

    @Override
    protected boolean executePayment(Order order) {
        System.out.println("3. Processing CASH payment...");

        System.out.println("   Customer pays cash at the counter.");

        System.out.println("   Cash payment received.");

        return true;
    }
}