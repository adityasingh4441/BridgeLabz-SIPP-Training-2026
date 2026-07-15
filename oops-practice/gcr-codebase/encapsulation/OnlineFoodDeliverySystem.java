public class OnlineFoodDeliverySystem {
    static abstract class FoodItem {
        private String itemName;
        private double price;
        private int quantity;

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        abstract double calculateTotalPrice();

        void displayItemDetails() {
            System.out.println("Item Name: " + itemName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
        }
    }

    static class VegItem extends FoodItem {
        @Override
        double calculateTotalPrice() {
            return getPrice() * getQuantity();
        }
    }

    static class NonVegItem extends FoodItem {
        private double serviceCharge;

        public double getServiceCharge() {
            return serviceCharge;
        }

        public void setServiceCharge(double serviceCharge) {
            this.serviceCharge = serviceCharge;
        }

        @Override
        double calculateTotalPrice() {
            return (getPrice() * getQuantity()) + serviceCharge;
        }
    }

    public static void main(String[] args) {
        VegItem vegItem = new VegItem();
        vegItem.setItemName("Paneer Roll");
        vegItem.setPrice(120);
        vegItem.setQuantity(2);

        NonVegItem nonVegItem = new NonVegItem();
        nonVegItem.setItemName("Chicken Biryani");
        nonVegItem.setPrice(220);
        nonVegItem.setQuantity(1);
        nonVegItem.setServiceCharge(30);

        vegItem.displayItemDetails();
        System.out.println("Total Price: " + vegItem.calculateTotalPrice());

        nonVegItem.displayItemDetails();
        System.out.println("Total Price: " + nonVegItem.calculateTotalPrice());
    }
}
