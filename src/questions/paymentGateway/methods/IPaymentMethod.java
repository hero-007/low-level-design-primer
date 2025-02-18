package questions.paymentGateway.methods;

public interface IPaymentMethod {
  void processPayment(PaymentRequest request);
}
