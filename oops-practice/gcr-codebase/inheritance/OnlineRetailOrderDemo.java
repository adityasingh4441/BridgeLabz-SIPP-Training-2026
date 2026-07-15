public class OnlineRetailOrderDemo {
    static class Order {
        private int orderId;
        private String orderDate;

        Order(int orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }

        String getOrderStatus() {
            return "Order placed";
        }

        void displayOrder() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Order Date: " + orderDate);
        }
    }

    static class ShippedOrder extends Order {
        private String trackingNumber;

        ShippedOrder(int orderId, String orderDate, String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }

        @Override
        String getOrderStatus() {
            return "Order shipped with tracking number " + trackingNumber;
        }
    }

    static class DeliveredOrder extends ShippedOrder {
        private String deliveryDate;

        DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        @Override
        String getOrderStatus() {
            return "Order delivered on " + deliveryDate;
        }
    }

    public static void main(String[] args) {
        Order order = new Order(101, "2026-07-10");
        ShippedOrder shippedOrder = new ShippedOrder(102, "2026-07-11", "TRK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder(103, "2026-07-12", "TRK67890", "2026-07-15");

        Order[] orders = {order, shippedOrder, deliveredOrder};
        for (Order currentOrder : orders) {
            currentOrder.displayOrder();
            System.out.println(currentOrder.getOrderStatus());
        }
    }
}
