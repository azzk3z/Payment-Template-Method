package payment;

public class EWalletPayment extends PaymentProcessor {

    private String walletId;

    public EWalletPayment(String walletId) {
        this.walletId = walletId;
    }

    @Override
    protected boolean executePayment(Order order) {
        System.out.println("3. Processing E-WALLET payment...");

        if (walletId == null || walletId.isBlank()) {
            System.out.println("   Invalid wallet account!");
            return false;
        }

        System.out.println("   Connecting to e-wallet...");
        System.out.println("   Verifying wallet account...");
        System.out.println("   E-wallet payment approved.");

        return true;
    }
}