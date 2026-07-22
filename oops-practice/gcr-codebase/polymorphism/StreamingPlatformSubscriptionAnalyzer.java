public class StreamingPlatformSubscriptionAnalyzer {
    public static void main(String[] args) {
        Subscription[] subscriptions = {
                new BasicPlan("Asha", "B001"),
                new PremiumPlan("Vikram", "P002"),
                new FamilyPlan("Nisha", "F003"),
                new BasicPlan("Ravi", "B004"),
                new PremiumPlan("Sonia", "P005")
        };

        StreamingPlatformSubscriptionAnalyzer analyzer = new StreamingPlatformSubscriptionAnalyzer();

        System.out.println("Total monthly revenue: " + analyzer.calculateTotalMonthlyRevenue(subscriptions));
        analyzer.searchSubscriptionById(subscriptions, "P002");
        analyzer.displaySubscribersStartingWith(subscriptions, 'N');
        analyzer.displayMostExpensiveSubscription(subscriptions);
    }

    public double calculateTotalMonthlyRevenue(Subscription[] subscriptions) {
        double total = 0;
        for (Subscription subscription : subscriptions) {
            total += subscription.calculateMonthlyCharge();
        }
        return total;
    }

    public void searchSubscriptionById(Subscription[] subscriptions, String subscriptionId) {
        for (Subscription subscription : subscriptions) {
            if (subscription.getSubscriptionId().equalsIgnoreCase(subscriptionId)) {
                System.out.println("Subscription found: " + subscription.getSubscriberName() + " -> " + subscription.getSubscriptionId());
                return;
            }
        }
        System.out.println("Subscription not found.");
    }

    public void displaySubscribersStartingWith(Subscription[] subscriptions, char letter) {
        System.out.println("Subscribers starting with '" + letter + "':");
        for (Subscription subscription : subscriptions) {
            if (subscription.getSubscriberName().charAt(0) == Character.toUpperCase(letter)) {
                System.out.println(subscription.getSubscriberName());
            }
        }
    }

    public void displayMostExpensiveSubscription(Subscription[] subscriptions) {
        Subscription mostExpensive = subscriptions[0];
        for (Subscription subscription : subscriptions) {
            if (subscription.calculateMonthlyCharge() > mostExpensive.calculateMonthlyCharge()) {
                mostExpensive = subscription;
            }
        }
        System.out.println("Most expensive subscription: " + mostExpensive.getSubscriberName() + " (" + mostExpensive.getClass().getSimpleName() + ")");
    }
}

abstract class Subscription {
    protected String subscriberName;
    protected String subscriptionId;

    public Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    public abstract double calculateMonthlyCharge();

    public String getSubscriberName() {
        return subscriberName;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }
}

class BasicPlan extends Subscription {
    public BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 199.0;
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 499.0;
    }
}

class FamilyPlan extends Subscription {
    public FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 799.0;
    }
}
