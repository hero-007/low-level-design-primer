package questions.paymentGateway;

import questions.paymentGateway.banks.BankingPartner;
import questions.paymentGateway.banks.BankingPartnerManager;
import questions.paymentGateway.clients.DefaultPaymentGatewayClient;
import questions.paymentGateway.clients.PaymentGatewayClientManager;
import questions.paymentGateway.gateway.PaymentGateway;
import questions.paymentGateway.methods.PaymentMethodManager;
import questions.paymentGateway.methods.PaymentRequest;
import questions.paymentGateway.methods.UPIPaymentMethod;
import questions.paymentGateway.methods.UPIPaymentRequest;
import questions.paymentGateway.payment.IPaymentOrder;
import questions.paymentGateway.payment.PaymentOrder;
import questions.paymentGateway.payment.PaymentOrderStatus;
import questions.paymentGateway.routers.HighestSuccessRateRoutingStratergy;
import questions.paymentGateway.routers.PaymentRouter;

public class Main {

  public static void main(String args[]) {
    BankingPartnerManager bankingPartnerManager = BankingPartnerManager.getInstance();

    bankingPartnerManager.addBankingPartner(new BankingPartner("HDFC Bank"));
    bankingPartnerManager.addBankingPartner(new BankingPartner("Yes Bank"));

    PaymentMethodManager paymentMethodManager = PaymentMethodManager.getInstance();
    paymentMethodManager.addPaymentMethod(new UPIPaymentMethod());

    PaymentGatewayClientManager paymentGatewayClientManager = PaymentGatewayClientManager.getInstance();
    paymentGatewayClientManager.addClient(new DefaultPaymentGatewayClient("Porter"));

    PaymentRouter highestSuccessRateRouter = new HighestSuccessRateRoutingStratergy();
    PaymentGateway paymentGateway = PaymentGateway.getInstance(highestSuccessRateRouter);

    PaymentRequest paymentRequest = new UPIPaymentRequest("8449689598", "9258968143", 12000.0F);
    IPaymentOrder paymentOrder = paymentGateway.initiatePayment(paymentRequest);

    System.out.println(paymentOrder);

    PaymentOrderStatus paymentOrderStatus = paymentGateway.processPayment(paymentOrder);
    System.out.println(paymentOrderStatus);
  }
}
