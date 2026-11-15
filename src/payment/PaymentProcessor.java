package payment;

public abstract class PaymentProcessor {

    // Template Method: định nghĩa khung thuật toán
    public final void processPayment(Order order) {

        System.out.println("\n========== PAYMENT PROCESS ==========");

        // Bước 1: Kiểm tra đơn hàng
        validateOrder(order);

        // Bước 2: Kiểm tra số tiền
        validateAmount(order);

        // Bước 3: Thực hiện thanh toán
        boolean success = executePayment(order);

        // Bước 4: Lưu giao dịch
        if (success) {
            saveTransaction(order);

            // Bước 5: Thông báo kết quả
            notifyCustomer(order, true);
        } else {
            notifyCustomer(order, false);
        }

        System.out.println("=====================================");
    }

    // Các bước xử lý chung
    protected void validateOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null!");
        }

        if (order.getOrderId() == null
                || order.getOrderId().isBlank()
                || order.getCustomerName() == null
                || order.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Invalid order information!");
        }

        System.out.println("1. Order validation successful.");
    }

    protected void validateAmount(Order order) {
        if (!Double.isFinite(order.getAmount())
                || order.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid payment amount!");
        }

        System.out.println("2. Amount validation successful.");
    }

    // Bước thay đổi tùy từng phương thức thanh toán
    protected abstract boolean executePayment(Order order);

    // Các bước xử lý chung
    protected void saveTransaction(Order order) {
        System.out.println("4. Transaction saved successfully.");
        System.out.println("   Order ID: " + order.getOrderId());
        System.out.printf("   Amount: %,.0f VND%n", order.getAmount());
    }

    protected void notifyCustomer(Order order, boolean success) {
        if (success) {
            System.out.println("5. Notification: Payment successful!");
            System.out.println("   Customer: " + order.getCustomerName());
        } else {
            System.out.println("5. Notification: Payment failed!");
        }
    }
}