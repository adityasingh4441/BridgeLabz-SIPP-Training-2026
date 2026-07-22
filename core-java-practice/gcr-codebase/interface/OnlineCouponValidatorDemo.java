interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() == 8;
    }
}

class ShoppingCart implements CouponValidator {
    private String[] validCoupons = {"SAVE2026", "SHOP1000", "FEST2026"};

    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }

        for (String coupon : validCoupons) {
            if (coupon.equals(code)) {
                return true;
            }
        }
        return false;
    }
}

public class OnlineCouponValidatorDemo {
    public static void main(String[] args) {
        String[] coupons = {"SAVE2026", "WELCOME", "SHOP1000", "INVALID1", "FEST2026"};
        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            if (cart.validateCoupon(coupon)) {
                System.out.println(coupon + " is valid");
            } else {
                System.out.println(coupon + " is invalid");
            }
        }
    }
}
