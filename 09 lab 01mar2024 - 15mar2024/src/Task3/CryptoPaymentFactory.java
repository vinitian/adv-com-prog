package Task3;

public class CryptoPaymentFactory implements PaymentMethodFactory {
    public PaymentMethod createPaymentMethod(){
        return new CryptoPayment();
    }
}
