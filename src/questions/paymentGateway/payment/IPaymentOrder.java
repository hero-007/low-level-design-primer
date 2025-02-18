package questions.paymentGateway.payment;

import java.util.UUID;

public interface IPaymentOrder {
  UUID getPaymentOrderIdentifier();
  PaymentOrderStatus getPaymentOrderStatus();

  PaymentOrderStatus updatePaymentOrderStatus(PaymentOrderStatus updatedStatus);
}
