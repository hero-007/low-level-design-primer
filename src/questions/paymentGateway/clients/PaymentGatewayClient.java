package questions.paymentGateway.clients;

import questions.paymentGateway.banks.IBankingPartner;
import questions.paymentGateway.methods.IPaymentMethod;

import java.util.List;

public interface PaymentGatewayClient {
  void initiatePayment();

  void addPaymentMethod(IPaymentMethod IPaymentMethod);
  void removePaymentMethod(IPaymentMethod IPaymentMethod);
  List<IPaymentMethod> getAllPaymentMethods();

  void addBankingPartner(IBankingPartner bankingPartner);
}
