package questions.paymentGateway.payment;

import java.util.UUID;

public class PaymentOrder implements IPaymentOrder{
  private UUID uuid;
  private PaymentOrderStatus paymentOrderStatus;

  public PaymentOrder() {
    this.uuid = UUID.randomUUID();
    this.paymentOrderStatus = PaymentOrderStatus.GENERATED;
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
  public PaymentOrderStatus updatePaymentOrderStatus(PaymentOrderStatus updatedStatus) {
    paymentOrderStatus = updatedStatus;
    return this.paymentOrderStatus;
  }


}
