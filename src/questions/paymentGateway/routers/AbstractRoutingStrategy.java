package questions.paymentGateway.routers;

import questions.paymentGateway.banks.BankingPartnerManager;

abstract class AbstractRoutingStrategy implements PaymentRouter {

  protected BankingPartnerManager bankingPartnerManager;

  public AbstractRoutingStrategy() {
    this.bankingPartnerManager = BankingPartnerManager.getInstance();
  }

}
