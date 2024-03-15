package Task3;

public class CreditCardPaymentFactory implements PaymentMethodFactory {
    public PaymentMethod createPaymentMethod(){
        return new CreditCardPayment();
    }
}
