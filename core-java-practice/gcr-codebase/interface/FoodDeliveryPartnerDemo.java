interface FoodDelivery {
    void deliverFood(String customerName);

    default void trackOrder(String customerName) {
        System.out.println("Food order for " + customerName + " is out for delivery");
    }

    static String generateDeliveryCode() {
        return "FD" + System.currentTimeMillis() % 10000;
    }
}

interface GroceryDelivery {
    void deliverGroceries(String customerName);

    default void trackOrder(String customerName) {
        System.out.println("Grocery order for " + customerName + " is out for delivery");
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    public void deliverFood(String customerName) {
        System.out.println("Delivered food to " + customerName);
    }

    public void deliverGroceries(String customerName) {
        System.out.println("Delivered groceries to " + customerName);
    }

    public void trackOrder(String customerName) {
        FoodDelivery.super.trackOrder(customerName);
        GroceryDelivery.super.trackOrder(customerName);
    }

    public void processDelivery(String customerName) {
        System.out.println("Delivery Code: " + FoodDelivery.generateDeliveryCode());
        trackOrder(customerName);
        deliverFood(customerName);
        deliverGroceries(customerName);
    }
}

public class FoodDeliveryPartnerDemo {
    public static void main(String[] args) {
        String[] customerNames = {"Isha", "Rahul", "Tara"};
        DeliveryExecutive executive = new DeliveryExecutive();

        for (String customerName : customerNames) {
            executive.processDelivery(customerName);
        }
    }
}
