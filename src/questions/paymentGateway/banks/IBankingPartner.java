package questions.paymentGateway.banks;

import questions.paymentGateway.methods.IPaymentMethod;
import questions.paymentGateway.payment.IPaymentOrder;
import questions.paymentGateway.payment.PaymentOrderStatus;

import java.util.List;
import java.util.UUID;

public interface IBankingPartner {

  IPaymentOrder initiatePayment();
  PaymentOrderStatus processPayment(IPaymentOrder paymentOrder);
  boolean cancelPayment(UUID paymentOrderId);

  void addPaymentMethod(IPaymentMethod IPaymentMethod);
  void removePaymentMethod(IPaymentMethod IPaymentMethod);
  List<IPaymentMethod> getAllSupportedPaymentMethods();

  double getSuccessRate();
}
