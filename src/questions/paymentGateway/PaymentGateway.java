package questions.paymentGateway;

import questions.paymentGateway.banks.IBankingPartner;
import questions.paymentGateway.banks.BankingPartnerManager;
import questions.paymentGateway.clients.PaymentGatewayClient;
import questions.paymentGateway.clients.PaymentGatewayClientManager;
import questions.paymentGateway.methods.IPaymentMethod;
import questions.paymentGateway.methods.PaymentMethodsManager;

public class PaymentGateway {
  private static PaymentGateway paymentGateway;

  private PaymentGatewayClientManager paymentGatewayClientManager;
  private PaymentMethodsManager paymentMethodsManager;
  private BankingPartnerManager bankingPartnerManager;

  private PaymentGateway() {
    paymentGatewayClientManager = PaymentGatewayClientManager.getInstance();
    paymentMethodsManager = new PaymentMethodsManager();
    bankingPartnerManager = BankingPartnerManager.getInstance();
  }

  public static PaymentGateway getInstance() {
    if (paymentGateway == null)
      paymentGateway = new PaymentGateway();

    return paymentGateway;
  }

  public void addClient(PaymentGatewayClient paymentGatewayClient) {
    paymentGatewayClientManager.addClient(paymentGatewayClient);
  }

  public void removeClient(PaymentGatewayClient paymentGatewayClient) {
    paymentGatewayClientManager.removeClient(paymentGatewayClient);
  }

  public void addPaymentMethod(IPaymentMethod IPaymentMethod) {
    paymentMethodsManager.addPaymentMethod(IPaymentMethod);
  }

  public void removePaymentMethod(IPaymentMethod IPaymentMethod) {
    paymentMethodsManager.removePaymentMethod(IPaymentMethod);
  }

  public void addBankingPartner(IBankingPartner IBankingPartner) {
    bankingPartnerManager.addBankingPartner(IBankingPartner);
  }

  public void removeBankingPartner(IBankingPartner IBankingPartner) {
    bankingPartnerManager.removeBankingPartner(IBankingPartner);
  }


}
