package questions.paymentGateway.clients;

import questions.paymentGateway.banks.BankingPartnerManager;
import questions.paymentGateway.banks.IBankingPartner;
import questions.paymentGateway.methods.IPaymentMethod;
import questions.paymentGateway.methods.PaymentMethodManager;
import java.util.List;
import java.util.UUID;

public class DefaultPaymentGatewayClient implements IPaymentGatewayClient {
  private UUID uuid;
  private String name;
  private PaymentMethodManager paymentMethodManager;
  private BankingPartnerManager bankingPartnerManager;

  public DefaultPaymentGatewayClient(String name) {
    this.uuid = UUID.randomUUID();
    this.name = name;
    this.paymentMethodManager = PaymentMethodManager.getInstance();
    this.bankingPartnerManager = BankingPartnerManager.getInstance();
  }

  @Override
  public void addPaymentMethod(IPaymentMethod paymentMethod) {
    paymentMethodManager.addPaymentMethod(paymentMethod);
  }

  @Override
  public void removePaymentMethod(IPaymentMethod paymentMethod) {
    paymentMethodManager.removePaymentMethod(paymentMethod);
  }

  @Override
  public List<IPaymentMethod> getAllPaymentMethods() {
    return paymentMethodManager.getAllSupportedPaymentMethods();
  }

  @Override
  public void addBankingPartner(IBankingPartner bankingPartner) {
    bankingPartnerManager.addBankingPartner(bankingPartner);
  }

  @Override
  public void removeBakingPartner(IBankingPartner bankingPartner) {
    bankingPartnerManager.removeBankingPartner(bankingPartner);
  }

  @Override
  public List<IBankingPartner> getAllBankingPartners() {
    return bankingPartnerManager.getAllBankingPartners();
  }
}
