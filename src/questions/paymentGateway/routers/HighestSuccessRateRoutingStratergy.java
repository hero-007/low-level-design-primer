package questions.paymentGateway.routers;

import designPatterns.strategy.RouteStrategy;
import questions.paymentGateway.banks.IBankingPartner;
import questions.paymentGateway.methods.PaymentRequest;

public class HighestSuccessRateRoutingStratergy extends AbstractRoutingStrategy {

  @Override
  public IBankingPartner getAppropriateBank(PaymentRequest paymentRequest) {
    return bankingPartnerManager.getAllBankingPartners().get(0);
  }

}
