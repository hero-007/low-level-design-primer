package questions.paymentGateway.gateway;

import questions.paymentGateway.banks.IBankingPartner;
import questions.paymentGateway.banks.BankingPartnerManager;
import questions.paymentGateway.clients.PaymentGatewayClientManager;
import questions.paymentGateway.methods.PaymentMethodManager;
import questions.paymentGateway.methods.PaymentRequest;
import questions.paymentGateway.payment.IPaymentOrder;
import questions.paymentGateway.payment.PaymentOrderStatus;
import questions.paymentGateway.routers.PaymentRouter;

public class PaymentGateway {
  private static PaymentGateway paymentGateway;

  private PaymentGatewayClientManager paymentGatewayClientManager;
  private PaymentMethodManager paymentMethodManager;
  private BankingPartnerManager bankingPartnerManager;
  private PaymentRouter paymentRouter;

  private PaymentGateway(PaymentRouter paymentRouter) {
    paymentGatewayClientManager = PaymentGatewayClientManager.getInstance();
    paymentMethodManager = PaymentMethodManager.getInstance();
    bankingPartnerManager = BankingPartnerManager.getInstance();

    this.paymentRouter = paymentRouter;
  }

  public static PaymentGateway getInstance(PaymentRouter paymentRouter) {
    if (paymentGateway == null)
      paymentGateway = new PaymentGateway(paymentRouter);

    return paymentGateway;
  }

  public IPaymentOrder initiatePayment(PaymentRequest paymentRequest) {
    // Add validations based on client initiating the request and methods selected
    IBankingPartner bankingPartner = paymentRouter.getAppropriateBank(paymentRequest);
    IPaymentOrder paymentOrder = bankingPartner.initiatePayment(paymentRequest);
    return paymentOrder;
  }

  public PaymentOrderStatus processPayment(IPaymentOrder paymentOrder) {
    PaymentRequest paymentRequest = paymentOrder.getPaymentRequest();
    IBankingPartner bankingPartner = paymentRouter.getAppropriateBank(paymentRequest);
    PaymentOrderStatus paymentOrderStatus = bankingPartner.processPayment(paymentOrder);

    return paymentOrderStatus;
  }


}
