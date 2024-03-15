package Task2;

public class PaymentMethodFactory {
    public PaymentMethod createPaymentMethod(String method){
        if (method.equals("credit card")){
            return new CreditCardPayment();
        }
        else if (method.equals("paypal")){
            return new PayPalPayment();
        }
        else if (method.equals("crypto")){
            return new CryptoPayment();
        }
        return null;
    }
}