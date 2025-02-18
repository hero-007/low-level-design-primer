package questions.paymentGateway.routers;

import questions.paymentGateway.banks.IBankingPartner;
import questions.paymentGateway.methods.PaymentRequest;

public interface PaymentRouter {
  IBankingPartner getAppropriateBank(PaymentRequest paymentRequest);
}
