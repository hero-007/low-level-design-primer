package questions.paymentGateway.payment;

import questions.paymentGateway.methods.PaymentRequest;

import java.util.UUID;

public interface IPaymentOrder {
  UUID getPaymentOrderIdentifier();
  PaymentOrderStatus getPaymentOrderStatus();
  PaymentRequest getPaymentRequest();

  PaymentOrderStatus updatePaymentOrderStatus(PaymentOrderStatus updatedStatus);
}
