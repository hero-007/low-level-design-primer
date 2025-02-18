package questions.paymentGateway.clients;

import questions.paymentGateway.banks.IBankingPartner;
import questions.paymentGateway.methods.IPaymentMethod;

import java.util.List;

public interface IPaymentGatewayClient {
  void addPaymentMethod(IPaymentMethod IPaymentMethod);
  void removePaymentMethod(IPaymentMethod IPaymentMethod);
  List<IPaymentMethod> getAllPaymentMethods();

  void addBankingPartner(IBankingPartner bankingPartner);
  void removeBakingPartner(IBankingPartner bankingPartner);
  List<IBankingPartner> getAllBankingPartners();
}
