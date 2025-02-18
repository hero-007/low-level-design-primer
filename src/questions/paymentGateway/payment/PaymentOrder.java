package questions.paymentGateway.payment;

import questions.paymentGateway.methods.PaymentRequest;

import java.util.UUID;

public class PaymentOrder implements IPaymentOrder{
  private UUID uuid;
  private PaymentOrderStatus paymentOrderStatus;
  private PaymentRequest paymentRequest;

  public PaymentOrder(PaymentRequest paymentRequest) {
    this.uuid = UUID.randomUUID();
    this.paymentOrderStatus = PaymentOrderStatus.GENERATED;
    this.paymentRequest = paymentRequest;
  }

  @Override
  public UUID getPaymentOrderIdentifier() {
    return uuid;
  }

  @Override
  public PaymentOrderStatus getPaymentOrderStatus() {
    return paymentOrderStatus;
  }

  @Override
  public PaymentRequest getPaymentRequest() {
    return paymentRequest;
  }


  @Override
  public PaymentOrderStatus updatePaymentOrderStatus(PaymentOrderStatus updatedStatus) {
    paymentOrderStatus = updatedStatus;
    return this.paymentOrderStatus;
  }

  @Override
  public String toString() {
    return "PaymentOrder{" +
      "uuid=" + uuid +
      ", paymentOrderStatus=" + paymentOrderStatus +
      ", paymentRequest=" + paymentRequest +
      '}';
  }
}
